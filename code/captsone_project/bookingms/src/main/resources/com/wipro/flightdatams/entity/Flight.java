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
	private int id;
	
	@Column(name="flight_number")
	private String flightNumber;
	
	@Column(name="airline")
	private String airline;
	
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="price_effective_from")
	private LocalDate priceEffectiveFrom;
	@Column(name="price_effective_to")
	private LocalDate priceEffectiveTo;
	@Column(name="price")
	private double price;
}
