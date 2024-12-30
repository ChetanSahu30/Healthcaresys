package com.healthcare.dao;

import com.healthcare.database.DatabaseConnection;
import com.healthcare.models.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.List;

public class AppointmentDAOTest {

    private AppointmentDAO appointmentDAO;
    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        appointmentDAO = new AppointmentDAO();

        // Mock database connection and prepared statement
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // When we get the mock connection, return the mock prepared statement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);

        // Simulate an appointment in the result set
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getInt("patient_id")).thenReturn(1001);
        when(mockResultSet.getInt("doctor_id")).thenReturn(2001);
        when(mockResultSet.getTimestamp("appointment_date")).thenReturn(new Timestamp(System.currentTimeMillis()));

        // Mock the DatabaseConnection to return the mock connection
        DatabaseConnection.setConnection(mockConnection);
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment(1, 1001, 2001, new java.util.Date());

        // Call the method under test
        appointmentDAO.addAppointment(appointment);

        // Verify that the prepared statement is executed
        try {
            verify(mockStatement).executeUpdate();
        } catch (SQLException e) {
            fail("SQLException occurred during the test");
        }
    }

    @Test
    public void testGetAllAppointments() {
        // Call the method under test
        List<Appointment> appointments = appointmentDAO.getAllAppointments();

        // Verify the list is not empty and contains at least one appointment
        assertFalse(appointments.isEmpty());
        assertEquals(1, appointments.size());

        // Verify appointment details
        Appointment appointment = appointments.get(0);
        assertEquals(1, appointment.getId());
        assertEquals(1001, appointment.getPatientId());
        assertEquals(2001, appointment.getDoctorId());
    }
}
