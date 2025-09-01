package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // PassengerRepository no longer needed directly; cascade from Booking

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Booking createBooking(Long flightId, java.util.List<com.wipro.bookingms.model.Passenger> passengers) {
        Booking booking = new Booking();
        booking.setFlightId(flightId);
        booking.setStatus("initiated");
        booking.setPassengers(passengers);
        return bookingRepository.save(booking);
    }

    @Override
    public void initiatePayment(Long bookingId, Map<String, Object> paymentDetails) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            // Throw runtime exception — controller ExceptionHandler will convert to 404
            // JSON
            throw new RuntimeException("Booking not found: " + bookingId);
        }

        Booking booking = optionalBooking.get();
        booking.setStatus("pending");
        bookingRepository.save(booking);

        // Pad month to 2 digits to be neat (Payment MS expects MM/yyyy ideally)
        String monthRaw = paymentDetails.get("expiryMonth") != null
                ? String.valueOf(paymentDetails.get("expiryMonth")).trim()
                : null;
        String month = monthRaw;
        if (month != null && month.length() == 1) {
            month = "0" + month;
        }

        String year = paymentDetails.get("expiryYear") != null ? String.valueOf(paymentDetails.get("expiryYear")).trim()
                : "";
        String expiry = (month != null ? month : "") + "/" + year;

        // Build message matching Payment MS parsing expectations
        String message = "Booking ID: " + bookingId +
                ", Amount: " + paymentDetails.get("amount") +
                ", Method: " + paymentDetails.get("method") +
                ", Card Number: " + paymentDetails.get("cardNumber") +
                ", Card Holder: " + paymentDetails.get("nameOnCard") +
                ", Expiry Date: " + expiry +
                ", CVV: " + paymentDetails.get("cvv");

        kafkaTemplate.send("T1", message);
    }

    @KafkaListener(topics = "T2", groupId = "booking-group")
    public void updateStatusFromT2(String message) {
        // Parse message from T2 (format: "Booking ID: 1, Status: successful")
        try {
            String[] parts = message.split(",");
            Long bookingId = Long.parseLong(parts[0].split(":")[1].trim());
            String status = parts[1].split(":")[1].trim();

            Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
            if (optionalBooking.isPresent()) {
                Booking booking = optionalBooking.get();
                booking.setStatus(status);
                bookingRepository.save(booking);
            }
        } catch (Exception ex) {
            // Log or ignore malformed T2 messages — do not crash the listener
            System.err.println("Failed to parse T2 message: " + message + " -> " + ex.getMessage());
        }
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public String getBookingStatus(Long id) {
        return bookingRepository.findById(id).map(Booking::getStatus).orElse(null);
    }
}
