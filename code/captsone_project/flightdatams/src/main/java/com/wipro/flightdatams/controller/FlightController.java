package com.wipro.flightdatams.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.repo.FlightRepo;
import com.wipro.flightdatams.service.FlightService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
@Tag(name = "Flight Data")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@Autowired
	FlightRepo flightRepo;
	
	@Operation(summary = "Search flights by source/destination/date")
	  @GetMapping("/search")
	  public ResponseEntity<List<Flight>> search(@RequestParam String source,
	                                             @RequestParam String destination,
	                                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	    return ResponseEntity.ok(flightService.search(source, destination, date));
	  }

	  @PostMapping
	  public ResponseEntity<Flight> create(@RequestBody Flight flight){
	    return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight));
	  }

	  @GetMapping("/flights/{id}")
	  public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
	      return flightRepo.findById(id)  // returns Optional<Flight>
	                       .map(ResponseEntity::ok)
	                       .orElse(ResponseEntity.notFound().build());
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<Flight> update(@PathVariable int id, @RequestBody Flight flight){
	    flight.setId(id);
	    return ResponseEntity.ok(flightService.update(flight));
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<Void> delete(@PathVariable int id){
		  flightService.deleteById(id);
	    return ResponseEntity.noContent().build();
	  }
}
