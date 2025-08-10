package com.wipro.day4;

import java.util.*;

class Employe {
 String empId;
 String empName;
 int empAge;

 public Employe(String empId, String empName, int empAge) {
     this.empId = empId;
     this.empName = empName;
     this.empAge = empAge;
 }

 public String toString() {
     return empId + " - " + empName + " - " + empAge;
 }
}
class SortByEmpId implements Comparator<Employee> {
 public int compare(Employee e1, Employee e2) {
     return e1.empId.compareTo(e2.empId);
 }
}

//Comparator to sort by empName
class SortByEmpName implements Comparator<Employee> {
 public int compare(Employee e1, Employee e2) {
     return e1.empName.compareTo(e2.empName);
 }
}

//Comparator to sort by empAge
class SortByEmpAge implements Comparator<Employee> {
 public int compare(Employee e1, Employee e2) {
     return Integer.compare(e1.empAge, e2.empAge);
 }
}

//Main class to test sorting
public class SortEmploye {
 public static void main(String[] args) {
     List<Employee> employees = new ArrayList<>();
     employees.add(new Employee("E103", "Alice", 30));
     employees.add(new Employee("E101", "Bob", 25));
     employees.add(new Employee("E102", "Charlie", 28));

     System.out.println("Original List:");
     for (Employee e : employees) {
         System.out.println(e);
     }

     // Sort by empId
     Collections.sort(employees, new SortByEmpId());
     System.out.println("\nSorted by empId:");
     for (Employee e : employees) {
         System.out.println(e);
     }

     Collections.sort(employees, new SortByEmpName());
     System.out.println("\nSorted by empName:");
     for (Employee e : employees) {
         System.out.println(e);
     }

     Collections.sort(employees, new SortByEmpAge());
     System.out.println("\nSorted by empAge:");
     for (Employee e : employees) {
         System.out.println(e);
     }
 }
}

