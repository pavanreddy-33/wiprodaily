package com.wipro.bookingms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.service.BookingService;


@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {
	
	@Autowired
	BookingService service;
	
	@GetMapping("/search")
	public ResponseEntity<List<Map>> search(@RequestParam String source, @RequestParam String destination,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return ResponseEntity.ok(service.searchFlights(source, destination, date));
	}

	@PostMapping("/book")
	public ResponseEntity<Booking> book(@RequestBody Map<String, Object> req) {
		Long flightId = Long.valueOf(String.valueOf(req.get("flightId")));
		String passengerName = (String) req.get("passengerName");
		LocalDate travelDate = LocalDate.parse((String) req.get("travelDate"));
		String cardNumber = (String) req.get("cardNumber");
		String expiry = (String) req.get("expiry");
		String paymentMode = (String) req.getOrDefault("paymentMode", "CARD");
		Booking b = service.initiateBooking(flightId, passengerName, travelDate, cardNumber, expiry, paymentMode);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> get(@PathVariable String bookingId) {
		return service.findByBookingId(bookingId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// additional CRUD
	@GetMapping
	public ResponseEntity<List<Booking>> list() {
		return ResponseEntity.ok(service.listAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Booking> update(@PathVariable int id, @RequestBody Booking b) {
		b.setId(id);
		return ResponseEntity.ok(service.update(b));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
