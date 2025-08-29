package com.wipro.flightdatams.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.flightdatams.entity.Flight;
import com.wipro.flightdatams.repo.FlightRepo;
import com.wipro.flightdatams.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepo flightRepo;
	
	@Override
	public List<Flight> findAll() {
		return flightRepo.findAll();
	}

	@Override
	public Flight findById(int id) {
		Optional<Flight> flightOpt= flightRepo.findById(id);
		if(flightOpt.isPresent())
		{
			return flightOpt.get();
		}
		return null;
	}

	@Override
	public Flight save(Flight flight) {
		return flightRepo.save(flight);
	}

	@Override
	public void deleteById(int id) {
		flightRepo.deleteById(id);
	}
	
	@Override
    public List<Flight> search(String source, String destination, LocalDate date) {
        return flightRepo.findBySourceAndDestinationAndDate(source, destination, date);
    }

	@Override
	public Flight update(Flight flight) {
		return flightRepo.save(flight);
	}

}
