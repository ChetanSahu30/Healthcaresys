package com.healthcare.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";
    private static final String DB_NAME = "healthcare_db";
    private static final String SCRIPT_PATH = "resources/database_script.sql";

    public static Connection getConnection() {
        try {
            // Connect to MySQL server (no database specified)
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Create the database if it does not exist
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(createDatabaseQuery);
            System.out.println("Database created (if it didn't exist already).");

            // Select the 'healthcare_db' database
            String useDatabaseQuery = "USE " + DB_NAME;
            stmt.executeUpdate(useDatabaseQuery);

            // Now, read and execute the SQL script to create tables and insert data
            try (BufferedReader reader = new BufferedReader(new FileReader(SCRIPT_PATH))) {
                StringBuilder sqlBuilder = new StringBuilder();
                String line;

                // Read and execute the SQL script line by line
                while ((line = reader.readLine()) != null) {
                    sqlBuilder.append(line);
                    if (line.trim().endsWith(";")) {
                        stmt.execute(sqlBuilder.toString());
                        sqlBuilder.setLength(0); // Clear the builder for the next statement
                    }
                }
            }

            System.out.println("Database initialized successfully!");

        } catch (Exception e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }
}
