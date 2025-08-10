package com.wipro.day4;

import java.util.concurrent.CopyOnWriteArrayList;

class Employee {
    String empId;
    String empName;
    int empAge;
    double salary;

    public Employee(String empId, String empName, int empAge, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return empId + " " + empName + " " + empAge + " "+ salary;
    }
}
