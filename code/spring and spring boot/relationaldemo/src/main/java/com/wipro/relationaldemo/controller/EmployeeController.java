package com.wipro.relationaldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.relationaldemo.entity.Employee;
import com.wipro.relationaldemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	void save(@RequestBody Employee emp) {
		employeeService.save(emp);
	}
	
	@GetMapping
	List<Employee> findAll(){
		return employeeService.findAll();
	}
}
