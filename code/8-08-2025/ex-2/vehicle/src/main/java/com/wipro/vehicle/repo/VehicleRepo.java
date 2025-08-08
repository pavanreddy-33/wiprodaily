package com.wipro.vehicle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.vehicle.entity.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Integer>{

}
