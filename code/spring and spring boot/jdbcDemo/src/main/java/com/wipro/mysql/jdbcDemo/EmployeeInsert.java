package com.wipro.mysql.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeInsert {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school"; 
        String user = "root";
        String password = "Chandu@123";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database!");

            String createTable = "CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "emp_name VARCHAR(45)," +
                    "department VARCHAR(45))";
            conn.createStatement().executeUpdate(createTable);
            System.out.println("Table 'employee' is ready.");

            String[][] employees = {
                {"John Doe", "IT"},
                {"Emily Clark", "Finance"},
                {"Amit Sharma", "Sales"},
                {"Sneha Reddy", "HR"},
                {"Raj Patel", "Marketing"}
            };

            String insertSQL = "INSERT INTO employee (emp_name, department) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            for (String[] emp : employees) {
                pstmt.setString(1, emp[0]);
                pstmt.setString(2, emp[1]);
                pstmt.executeUpdate();
            }

            System.out.println("Inserted " + employees.length + " record(s) into 'employee' table.");

            readEmployees(conn);

        } catch (SQLException e) {
            System.out.println("Error occurred:");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readEmployees(Connection conn) {
        String selectSQL = "SELECT id, emp_name, department FROM employee";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(selectSQL);
            rs = pstmt.executeQuery();

            System.out.println("\nEmployee Records:");
            System.out.println("----------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("emp_name");
                String dept = rs.getString("department");

                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + dept);
            }

        } catch (SQLException e) {
            System.out.println("Error while reading employees:");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
