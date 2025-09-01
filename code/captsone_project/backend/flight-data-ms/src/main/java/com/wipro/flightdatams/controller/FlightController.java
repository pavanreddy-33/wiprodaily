package com.wipro.flightdatams.controller;

import com.wipro.flightdatams.model.Flight;
import com.wipro.flightdatams.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Tag(name = "Flight API", description = "Endpoints for flight data management")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    @Operation(summary = "Search flights by origin, destination, and date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of matching flights"),
            @ApiResponse(responseCode = "404", description = "No flights found")
    })
    public ResponseEntity<List<Flight>> searchFlights(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Flight> flights = flightService.searchFlights(origin, destination, date);
        if (flights.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flights);
    }
}