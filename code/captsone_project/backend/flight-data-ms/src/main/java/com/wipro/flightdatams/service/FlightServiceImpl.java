package com.wipro.flightdatams.service;

import com.wipro.flightdatams.model.Flight;
import com.wipro.flightdatams.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> searchFlights(String origin, String destination, LocalDate date) {
        // Call the derived method
        return flightRepository.findByOriginAndDestinationAndDepartureDate(origin, destination, date);
    }
}