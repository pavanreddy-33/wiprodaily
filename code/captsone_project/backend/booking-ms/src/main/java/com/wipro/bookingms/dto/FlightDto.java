package com.wipro.bookingms.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FlightDto {
	private Long id;
	private String flightNumber;
	private String airline;
	private String origin;
	private String destination;
	private LocalDate departureDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private int durationMinutes;
	private double price;
	private int stops;
	private String aircraftName;
}