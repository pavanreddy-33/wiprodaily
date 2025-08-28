package com.wipro.flightdatams.dto;

import java.time.LocalDate;

public class FlightDto {
	Long id;
	String flightNumber;
	String aircraftName;
    String source; 
    String destination; 
    LocalDate date;
    double price;
}
