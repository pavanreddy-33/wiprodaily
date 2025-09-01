package com.wipro.paymentms.service;

import com.wipro.paymentms.model.Payment;
import com.wipro.paymentms.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//import java.time.LocalDate;
//import java.time.YearMonth;
//import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "T1", groupId = "payment-group")
    public void processPayment(String message) {
    // Expected format:
    // "Booking ID: 4, Amount: 5500.0, Method: CREDIT_CARD, Card Number: 4111111111111111,
    // Card Holder: JOHN DOE, Expiry Date: 2/2026, CVV: 123"
    try {
    String[] parts = message.split(",");


        Long bookingId = Long.parseLong(parts[0].substring(parts[0].indexOf(':') + 1).trim());
        double amount = Double.parseDouble(parts[1].substring(parts[1].indexOf(':') + 1).trim());
        String method = parts[2].substring(parts[2].indexOf(':') + 1).trim();
        String cardNumber = parts[3].substring(parts[3].indexOf(':') + 1).trim();
        String cardHolderName = parts[4].substring(parts[4].indexOf(':') + 1).trim();
        String expiryDateRaw = parts[5].substring(parts[5].indexOf(':') + 1).trim(); // e.g. "2/2026" or "02/2026"
        String cvv = parts[6].substring(parts[6].indexOf(':') + 1).trim();

        boolean expiryValid = false;
        try {
            // Accept both "2/2026" and "02/2026"
            java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("M/yyyy");
            java.time.YearMonth ym = java.time.YearMonth.parse(expiryDateRaw, fmt);
            expiryValid = ym.isAfter(java.time.YearMonth.now());
        } catch (Exception ex) {
            expiryValid = false;
        }

        boolean isValid = cardNumber != null && cardNumber.trim().length() == 16 && expiryValid;

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setAmount(amount);
        payment.setPaymentMethod(method);
        payment.setStatus(isValid ? "successful" : "failed");
        payment.setCardNumber(cardNumber);
        payment.setCardHolderName(cardHolderName);
        payment.setExpiryDate(expiryDateRaw);
        payment.setCvv(cvv);
        paymentRepository.save(payment);

        String response = "Booking ID: " + bookingId + ", Status: " + payment.getStatus();
        kafkaTemplate.send("T2", response);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }
}