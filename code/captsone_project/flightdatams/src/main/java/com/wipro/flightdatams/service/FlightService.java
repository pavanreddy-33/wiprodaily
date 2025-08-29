package com.wipro.flightdatams.service;

import java.time.LocalDate;
import java.util.List;

import com.wipro.flightdatams.entity.Flight;

public interface FlightService {
	public List<Flight> findAll();
	public Flight findById(int id);
	public Flight save(Flight flight);
	public Flight update(Flight flight);
	void deleteById(int id);
	List<Flight> search(String source, String destination, LocalDate date);
}
