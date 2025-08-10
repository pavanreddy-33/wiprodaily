package com.wipro.mysql.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "Chandu@123";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database!");

            Statement stmt = conn.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "age INT NOT NULL," +
                    "grade VARCHAR(10)" +
                    ")";
            stmt.executeUpdate(createTableQuery);
            System.out.println("✅ Table 'students' created successfully!");

            String insertDataQuery = "INSERT INTO students (name, age, grade) VALUES " +
                    "('Aarav Kumar', 14, '8th')," +
                    "('Diya Sharma', 13, '7th')," +
                    "('Rohan Mehta', 15, '9th')," +
                    "('Sneha Patel', 14, '8th')," +
                    "('Vikram Singh', 16, '10th')";

            int rowsInserted = stmt.executeUpdate(insertDataQuery);
            System.out.println("✅ Inserted " + rowsInserted + " records into 'students' table.");

            conn.close();

        } catch (SQLException e) {
            System.out.println("❌ Error:");
            e.printStackTrace();
        }
    }
}
