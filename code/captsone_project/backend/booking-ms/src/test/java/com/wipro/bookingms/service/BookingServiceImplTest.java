package com.wipro.bookingms.service;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void testCreateBooking() {
        java.util.List<Passenger> passengers = new java.util.ArrayList<>();
        Passenger p = new Passenger();
        p.setFullName("Test User");
        passengers.add(p);

        // Mock repository save: use any Booking and return with id
        org.mockito.Mockito.when(bookingRepository.save(org.mockito.Mockito.any(Booking.class)))
                .thenAnswer(invocation -> {
                    Booking b = invocation.getArgument(0);
                    b.setId(1L);
                    return b;
                });

        Booking result = bookingService.createBooking(1L, passengers);
        assertEquals("initiated", result.getStatus());
    }
}