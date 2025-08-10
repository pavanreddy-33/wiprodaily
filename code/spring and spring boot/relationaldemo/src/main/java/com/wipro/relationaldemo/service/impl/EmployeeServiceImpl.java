package com.wipro.relationaldemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.relationaldemo.entity.Employee;
import com.wipro.relationaldemo.repo.EmployeeRepo;
import com.wipro.relationaldemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Override
	public void save(Employee emp) {
		employeeRepo.save(emp);

	}

	@Override
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

}
