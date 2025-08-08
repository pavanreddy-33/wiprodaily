package com.wipro.vehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "vehicle_id")
    private Long vehId;

    @Column(name="latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lng;
}
