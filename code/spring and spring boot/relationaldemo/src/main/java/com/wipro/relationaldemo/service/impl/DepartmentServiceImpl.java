package com.wipro.relationaldemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.relationaldemo.entity.Department;
import com.wipro.relationaldemo.repo.DepartmentRepo;
import com.wipro.relationaldemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepo departmentRepo;
	
	@Override
	public void save(Department dep) {
		departmentRepo.save(dep);

	}

	@Override
	public List<Department> findAll() {
		return departmentRepo.findAll();
	}

}
