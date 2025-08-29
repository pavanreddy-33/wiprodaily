package com.wipro.flightdatams.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.flightdatams.entity.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {
	@Query("SELECT f FROM Flight f WHERE f.source = :source AND f.destination = :dest AND :date BETWEEN f.priceEffectiveFrom AND f.priceEffectiveTo")
	List<Flight> findBySourceAndDestinationAndDate(@Param("source") String source,
	                                               @Param("dest") String destination,
	                                               @Param("date") LocalDate date);
}
