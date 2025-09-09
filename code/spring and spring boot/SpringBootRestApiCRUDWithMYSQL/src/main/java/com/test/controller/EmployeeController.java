package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping 
	public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees); // 200 OK
    }
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Employee> create(@RequestBody Employee emp) {
		Employee saved = service.add(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
	
	@PutMapping("/id")
	public void update(@PathVariable long id,@RequestBody Employee emp) {
		service.update(id, emp);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {
		service.deleteById(id);
	}
}
