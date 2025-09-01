package com.wipro.flightdatams.service;

import com.wipro.flightdatams.model.Flight;
import com.wipro.flightdatams.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightServiceImplTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @Test
    public void testSearchFlights() {
        LocalDate date = LocalDate.now();
        List<Flight> mockFlights = List.of(new Flight());
        when(flightRepository.findByOriginAndDestinationAndDepartureDate("Kolkata", "Chennai", date)).thenReturn(mockFlights);

        List<Flight> result = flightService.searchFlights("Kolkata", "Chennai", date);
        assertEquals(1, result.size());
    }
}