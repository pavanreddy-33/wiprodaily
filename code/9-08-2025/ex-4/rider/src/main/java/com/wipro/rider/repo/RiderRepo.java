package com.wipro.rider.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rider.entity.Rider;

@Repository
public interface RiderRepo extends JpaRepository<Rider, Integer> {

}
