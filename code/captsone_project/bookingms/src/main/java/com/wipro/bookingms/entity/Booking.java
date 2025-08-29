package com.wipro.bookingms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "booking")
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="booking_id",unique=true)
	private String bookingId;
	@Column(name="flight_id")
	private Long flightId;
	@Column(name="passanger_name")
	private String passengerName;
	@Column(name="travel_date")
	private LocalDate travelDate;
	private Double amount;
	private String status; 
	@Column(name="created_at")
	private LocalDateTime createdAt;
}
