package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Employee;
import com.test.model.Employees;
import com.test.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping(value="/listemp", produces="application/json")
	public Employees getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@PostMapping(value="/empcreate", produces="application/json")
	public Employees createEmployee(@RequestBody Employee emp) {
		int id = service.getAllEmployees().getEmpList().size()+1;
		emp.setId(id);
		service.addEmployee(emp);
		return service.getAllEmployees();
	}
	
	@PutMapping(value="/empupdate/{id}", produces="application/json")
	public Employees updateEmployee(@PathVariable("id") int id,@RequestBody Employee emp) {
		emp.setId(id);
		service.updateEmployee(emp);
		return service.getAllEmployees();
	}
	
	@DeleteMapping(value="/empdelete/{id}", produces="application/json")
	public Employees deleteEmployee(@PathVariable("id") int id) {
		service.removeEmployee(id);
		return service.getAllEmployees();
	}
}
