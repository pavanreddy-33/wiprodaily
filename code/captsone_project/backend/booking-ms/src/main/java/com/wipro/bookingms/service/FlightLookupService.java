package com.wipro.bookingms.service;

import com.wipro.bookingms.dto.FlightDto;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class FlightLookupService {

private final RestTemplate restTemplate;
private final CircuitBreakerFactory<?, ?> cbFactory;

public FlightLookupService(RestTemplate restTemplate, CircuitBreakerFactory<?, ?> cbFactory) {
    this.restTemplate = restTemplate;
    this.cbFactory = cbFactory;
}

public List<FlightDto> searchFlights(String origin, String destination, LocalDate date) {
    CircuitBreaker cb = cbFactory.create("flightService");
    return cb.run(() -> {
        ResponseEntity<List<FlightDto>> resp = restTemplate.exchange(
            "http://flight-data-ms/flights/search?origin={o}&destination={d}&date={dt}",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<FlightDto>>() {},
            origin, destination, date.toString()
        );
        return resp.getBody() != null ? resp.getBody() : Collections.emptyList();
    }, throwable -> Collections.emptyList());
}
}