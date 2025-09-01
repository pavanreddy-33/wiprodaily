package com.wipro.bookingms.controller;

import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Test
    public void testCreateBooking() throws Exception {
        java.util.List<Passenger> passengers = new java.util.ArrayList<>();
        passengers.add(new Passenger());
        Booking booking = new Booking();
        booking.setId(1L);
        when(bookingService.createBooking(1L, passengers)).thenReturn(booking);

        mockMvc.perform(post("/booking/create?flightId=1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[{\"fullName\":\"John Doe\"}]")) // Sample body as array
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}