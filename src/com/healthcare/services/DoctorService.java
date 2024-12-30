package com.healthcare.services;

import com.healthcare.dao.DoctorDAO;
import com.healthcare.models.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDAO doctorDAO = new DoctorDAO();

    // Business logic for adding a new doctor
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);  // Delegate to DAO for adding doctor to the database
    }

    // Business logic for retrieving all doctors
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();  // Delegate to DAO to get all doctors
    }
}
