package com.wipro.relationaldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.relationaldemo.entity.Department;
import com.wipro.relationaldemo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	void save(@RequestBody Department dep) {
		departmentService.save(dep);
	}
	
	@GetMapping
	List<Department> findAll(){
		return departmentService.findAll();
	}
}
