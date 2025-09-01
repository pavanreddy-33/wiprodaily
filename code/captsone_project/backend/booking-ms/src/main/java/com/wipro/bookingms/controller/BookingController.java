package com.wipro.bookingms.controller;

import com.wipro.bookingms.dto.FlightDto;
import com.wipro.bookingms.model.Booking;
import com.wipro.bookingms.model.Passenger;
import com.wipro.bookingms.service.BookingService;
import com.wipro.bookingms.service.FlightLookupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
@Tag(name = "Booking API", description = "Endpoints for booking management")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightLookupService flightLookupService;

    @PostMapping("/create")
    @Operation(summary = "Create a booking with user details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Booking> createBooking(@RequestParam Long flightId, @RequestBody List<Passenger> passengers) {
        Booking booking = bookingService.createBooking(flightId, passengers);
        return ResponseEntity.ok(booking);
    }

    // 🔹 FIXED: JSON response instead of raw String
    @PostMapping(value = "/payments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Initiate payment for a booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment initiated"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Map<String, Object>> initiatePayment(@RequestParam Long bookingId,
            @RequestBody Map<String, Object> paymentDetails) {
        bookingService.initiatePayment(bookingId, paymentDetails);

        Map<String, Object> body = new HashMap<>();
        body.put("message", "Payment initiated");
        body.put("bookingId", bookingId);
        body.put("status", "pending");

        return ResponseEntity.ok(body);
    }

    @GetMapping("/bookings/{id}")
    @Operation(summary = "Get booking by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking found"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/bookings/{id}/status")
    @Operation(summary = "Get booking status (JSON)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Status returned"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
    })
    public ResponseEntity<Map<String, String>> getBookingStatus(@PathVariable Long id) {
        String status = bookingService.getBookingStatus(id);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        Map<String, String> body = new HashMap<>();
        body.put("status", status);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/search")
    @Operation(summary = "Search flights (aggregated via Booking MS)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of matching flights (possibly empty)")
    })
    public ResponseEntity<List<FlightDto>> search(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<FlightDto> list = flightLookupService.searchFlights(origin, destination, date);
        return ResponseEntity.ok(list);
    }

    // 🔹 Optional: make 404s return JSON instead of raw 500s
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(404).body(body);
    }
}
