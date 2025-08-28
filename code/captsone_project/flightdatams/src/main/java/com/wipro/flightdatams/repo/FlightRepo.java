package com.wipro.flightdatams.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.flightdatams.entity.Flight;

public interface FlightRepo extends JpaRepository<Flight, Long> {

}
