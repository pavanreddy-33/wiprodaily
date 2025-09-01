package com.wipro.flightdatams.service;

import com.wipro.flightdatams.model.Flight;
import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<Flight> searchFlights(String origin, String destination, LocalDate date);
}