package com.wipro.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.vehicle.entity.Vehicle;
import com.wipro.vehicle.service.VehicleService;

@RestController
@RequestMapping("/move")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping
	public List<Vehicle> getAll(){
		return vehicleService.getAllVehicles();
	}
	
	@PostMapping
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveMove(vehicle);
	}
}
