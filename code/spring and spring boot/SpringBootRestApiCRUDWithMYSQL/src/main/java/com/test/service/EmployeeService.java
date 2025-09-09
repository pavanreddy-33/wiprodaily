package com.test.service;

import java.util.List;

import com.test.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(long id);
	
	public Employee add(Employee emp);
	
	public void update(long id,Employee emp);
	
	public void deleteById(long id);
}
