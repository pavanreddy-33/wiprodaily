package com.wipro.flightdatams.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="airline")
	private String airline;
	@Column(name="flight_number")
	private String flightNumber;
	private String source;
	private String destination;
	private Double price;
	@Column(name="price_from")
	private LocalDate priceEffectiveFrom;
	@Column(name="price_to")
	private LocalDate priceEffectiveTo;
}
