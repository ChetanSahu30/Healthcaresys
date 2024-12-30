package com.healthcare.dao;

import com.healthcare.models.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorDAOTest {

    private DoctorDAO doctorDAO;

    @BeforeEach
    void setUp() {
        doctorDAO = new DoctorDAO();
        // Optionally, reset database before each test
    }

    @Test
    void testSaveDoctor() {
        Doctor doctor = new Doctor(1, "Dr. Smith", "Cardiology");
        
        // Save the doctor to the database
        doctorDAO.addDoctor(doctor);
        
        // Try to retrieve the doctor and assert the data
        Doctor retrievedDoctor = doctorDAO.getDoctorById(1);
        assertNotNull(retrievedDoctor);
        assertEquals("Dr. Smith", retrievedDoctor.getName());
        assertEquals("Cardiology", retrievedDoctor.getSpecialization());
    }
}
