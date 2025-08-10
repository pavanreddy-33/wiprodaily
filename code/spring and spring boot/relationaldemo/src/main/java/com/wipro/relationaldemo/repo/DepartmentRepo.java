package com.wipro.relationaldemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.relationaldemo.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
