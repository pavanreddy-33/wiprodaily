package com.wipro.flightdatams.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="flight")
@Data
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="flight_number")
	private String flightNumber;
	
	@Column(name="aircraft_name")
	private String aircraftName;
	
	private String source;
	private String destination;
	private LocalDate validFrom;
	private LocalDate validTo;
	private double price;
}
