package com.wipro.relationaldemo.service;

import java.util.List;

import com.wipro.relationaldemo.entity.Department;

public interface DepartmentService {
	
	void save(Department dep);
	List<Department> findAll();
}
