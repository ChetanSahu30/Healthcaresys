package com.healthcare.dao;

import com.healthcare.database.DatabaseConnection;
import com.healthcare.models.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (id, name, specialization) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                doctors.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("specialization")));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching doctors: " + e.getMessage());
        }
        return doctors;
    }
}