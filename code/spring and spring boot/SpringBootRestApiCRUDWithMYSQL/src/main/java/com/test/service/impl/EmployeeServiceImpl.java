package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Employee;
import com.test.repo.EmployeeRepo;
import com.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public List<Employee> findAll() {
		return null;
	}

	@Override
	public Employee findById(long id) {
		Employee e=repo.findById(id).get();
		return e;
	}

	@Override
	public Employee add(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public void update(long id, Employee emp) {
		emp.setId(id);
		repo.save(emp);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

}
