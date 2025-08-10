package com.wipro.uber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.uber.entity.Uber;

@Repository
public interface UberRepo extends JpaRepository<Uber, Integer> {
}
