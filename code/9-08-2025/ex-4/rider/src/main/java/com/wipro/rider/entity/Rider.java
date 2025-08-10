package com.wipro.rider.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="rider")
@Data
public class Rider {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String riderName;
	    private String pickup;
	    @Column(name = "drop_location")
	    private String dropLocation;
	    private String status;
	    private LocalDateTime timestamp;
	
}
