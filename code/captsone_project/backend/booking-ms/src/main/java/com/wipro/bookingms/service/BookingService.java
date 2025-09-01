package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import java.util.List;

import java.util.Map;

public interface BookingService {
    Booking createBooking(Long flightId, List<Passenger> passengers);

    void initiatePayment(Long bookingId, Map<String, Object> paymentDetails);

    Booking getBookingById(Long id);

    String getBookingStatus(Long id);
}