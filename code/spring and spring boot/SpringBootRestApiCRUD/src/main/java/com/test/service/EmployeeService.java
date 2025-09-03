package com.test.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.model.Employee;
import com.test.model.Employees;

@Repository
@Service
public class EmployeeService {
	
	static Employees emp = new Employees();
	
	static {
		emp.getEmpList().add(new Employee(1,"Pavan","Wipro"));
		emp.getEmpList().add(new Employee(2,"Sai","TCS"));
		emp.getEmpList().add(new Employee(3,"AA","EY"));
		emp.getEmpList().add(new Employee(4,"BB","Genpact"));
		emp.getEmpList().add(new Employee(5,"CC","CGI"));
	}
	
	public Employees getAllEmployees() {
		return emp;
	}
	
	public void addEmployee(Employee obj) {
		emp.getEmpList().add(obj);
	}
	
	public String updateEmployee(Employee e) {
		for(int i=0;i<emp.getEmpList().size();i++) {
			Employee obj = emp.getEmpList().get(i);
			if(obj.getId()==(e.getId())) {
				emp.getEmpList().set(i,e);
			}
		}
		return "the given id is not available";
	}
	
	public String removeEmployee(int id) {
		for(int i=0;i<emp.getEmpList().size();i++) {
			Employee obj = emp.getEmpList().get(i);
			if(obj.getId()==id) {
				emp.getEmpList().remove(i);
			}
		}
		return "the given id is not available";
	}
}
