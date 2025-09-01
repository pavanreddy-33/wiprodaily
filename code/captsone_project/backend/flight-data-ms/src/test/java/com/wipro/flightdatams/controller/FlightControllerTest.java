package com.wipro.flightdatams.controller;

import com.wipro.flightdatams.model.Flight;
import com.wipro.flightdatams.service.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightService flightService;

    @Test
    public void testSearchFlights() throws Exception {
        LocalDate date = LocalDate.now();
        List<Flight> mockFlights = List.of(new Flight());
        when(flightService.searchFlights("Kolkata", "Chennai", date)).thenReturn(mockFlights);

        mockMvc.perform(get("/flights/search")
                .param("origin", "Kolkata")
                .param("destination", "Chennai")
                .param("date", date.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}