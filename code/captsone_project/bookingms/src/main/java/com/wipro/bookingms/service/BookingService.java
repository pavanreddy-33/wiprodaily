package com.wipro.bookingms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.wipro.bookingms.dto.PaymentRequestMessage;
import com.wipro.bookingms.entity.Booking;
import com.wipro.bookingms.repo.BookingRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
	
	private final BookingRepo repo;
	  private final KafkaTemplate<String, Object> kafkaTemplate;
	  private final WebClient.Builder webClientBuilder;

	  private final String paymentTopic = "T1";
	  private final String flightBaseUrl = "http://localhost:9010/flight-data-ms/api/flights";

	  // CRUD
	  public Booking create(Booking b) {
	    b.setBookingId(UUID.randomUUID().toString());
	    b.setCreatedAt(LocalDateTime.now());
	    return repo.save(b);
	  }

		public Optional<Booking> findByBookingId(String bookingId) {
			return repo.findByBookingId(bookingId);
		}

		public List<Booking> listAll() {
			return repo.findAll();
		}

		public Booking update(Booking b) {
			return repo.save(b);
		}

		public void delete(int id) {
			repo.deleteById(id);
		}

	  @CircuitBreaker(name = "flightService", fallbackMethod = "flightSearchFallback")
	  public List<Map> searchFlights(String source, String destination, LocalDate date) {
	    WebClient client = webClientBuilder.baseUrl("http://localhost:9010").build();
	    Map[] resp = client.get()
	            .uri("/flight-data-ms/api/flights/search?source={s}&destination={d}&date={date}", source, destination, date.toString())
	            .retrieve().bodyToMono(Map[].class).block();
	    return resp == null ? Collections.emptyList() : Arrays.asList(resp);
	  }
	  public List<Map> flightSearchFallback(String source, String destination, LocalDate date, Throwable t) {
	    return Collections.emptyList();
	  }
	
	  public Booking initiateBooking(Long flightId, String passengerName, LocalDate travelDate, String cardNumber, String expiry, String paymentMode) {
	    WebClient client = webClientBuilder.baseUrl("http://localhost:9010").build();
	    Map flight = client.get().uri("/flight-data-ms/api/flights/{id}", flightId).retrieve().bodyToMono(Map.class).block();
	    Double amount = Double.valueOf(String.valueOf(flight.get("price")));

	    Booking b = new Booking();
	    b.setBookingId(UUID.randomUUID().toString());
	    b.setFlightId(flightId);
	    b.setPassengerName(passengerName);
	    b.setTravelDate(travelDate);
	    b.setAmount(amount);
	    b.setStatus("INITIATED");
	    b.setCreatedAt(LocalDateTime.now());
	    Booking saved = repo.save(b);

	    PaymentRequestMessage msg = new PaymentRequestMessage(saved.getBookingId(), saved.getAmount(), paymentMode, cardNumber, expiry);
	    kafkaTemplate.send(paymentTopic, saved.getBookingId(), msg);
	    return saved;
	  }
	  
	  @org.springframework.kafka.annotation.KafkaListener(topics = "T2", groupId = "booking-group", containerFactory = "kafkaListenerContainerFactory")
	  public void handlePaymentResult(Object obj) {
	    Map map = (Map)obj;
	    String bookingId = (String) map.get("bookingId");
	    String status = (String) map.get("status");
	    repo.findByBookingId(bookingId).ifPresent(b -> {
	      b.setStatus(status);
	      repo.save(b);
	    });
	  }
}
