package com.wipro.relationaldemo.service;

import java.util.List;

import com.wipro.relationaldemo.entity.Employee;

public interface EmployeeService {
	
	void save(Employee emp);
	List<Employee> findAll();
}
