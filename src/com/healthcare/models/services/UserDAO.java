package com.healthcare.dao;

import com.healthcare.models.User;
import java.sql.*;

public class UserDAO {

    // Method to save a user to the database
    public void saveUser(User user) {
        String query = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }
}
