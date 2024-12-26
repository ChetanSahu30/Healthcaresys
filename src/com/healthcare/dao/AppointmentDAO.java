package com.healthcare.dao;

import com.healthcare.database.DatabaseConnection;
import com.healthcare.models.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void addAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (id, patient_id, doctor_id, appointment_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointment.getId());
            stmt.setInt(2, appointment.getPatientId());
            stmt.setInt(3, appointment.getDoctorId());
            stmt.setTimestamp(4, new Timestamp(appointment.getAppointmentDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding appointment: " + e.getMessage());
        }
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getTimestamp("appointment_date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        }
        return appointments;
    }
}
