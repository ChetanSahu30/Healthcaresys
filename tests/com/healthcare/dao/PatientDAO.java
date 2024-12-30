package com.healthcare.dao;

import com.healthcare.database.DatabaseConnection;
import com.healthcare.models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Method to add a patient
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (id, name, gender, birth_date, contact_number) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patient.getId());
            stmt.setString(2, patient.getName());
            stmt.setString(3, patient.getGender());
            stmt.setDate(4, new java.sql.Date(patient.getBirthDate().getTime()));
            stmt.setString(5, patient.getContactNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding patient: " + e.getMessage());
        }
    }

    // Method to fetch all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                patients.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getDate("birth_date"),
                        rs.getString("contact_number")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching patients: " + e.getMessage());
        }
        return patients;
    }

    // Method to get a patient by ID
    public Patient getPatientById(int id) {
        Patient patient = null;
        String query = "SELECT * FROM patients WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    patient = new Patient(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getDate("birth_date"),
                            rs.getString("contact_number")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching patient by ID: " + e.getMessage());
        }
        return patient;
    }
}
