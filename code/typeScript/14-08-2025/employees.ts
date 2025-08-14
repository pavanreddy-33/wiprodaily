interface Employee {
  empId: number;
  empName: string;
  salary: number;
}


function printEmployees1(employees: Employee[]): number {
  employees.forEach(emp => {
    console.log(`ID: ${emp.empId}, Name: ${emp.empName}, Salary: ${emp.salary}`);
  });
  return employees.length;
}


const employeeList1: Employee[] = [
  { empId: 101, empName: "John Doe", salary: 50000 },
  { empId: 102, empName: "Jane Smith", salary: 60000 },
  { empId: 103, empName: "Mike Johnson", salary: 55000 }
];

const count2 = printEmployees(employeeList1);
console.log("Total Employees:", count2);