package com.wipro.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.vehicle.entity.Vehicle;
import com.wipro.vehicle.repo.VehicleRepo;

@Service
public class VehicleService {
	
	@Autowired
	VehicleRepo vehicleRepo;
	
	public Vehicle saveMove(Vehicle vehicle) {
		return vehicleRepo.save(vehicle);
	}
	
	public List<Vehicle> getAllVehicles(){
		return vehicleRepo.findAll();
	}
}
