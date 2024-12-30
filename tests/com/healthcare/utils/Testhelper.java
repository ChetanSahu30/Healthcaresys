package com.healthcare.utils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class TestHelper {

    // Method to clean up the database before tests
    public static void cleanUpDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthcare_db", "root", "password");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DELETE FROM users");
            stmt.executeUpdate("DELETE FROM doctors");
            stmt.executeUpdate("DELETE FROM patients");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
