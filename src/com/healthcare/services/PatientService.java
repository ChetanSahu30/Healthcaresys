package com.healthcare.services;

import com.healthcare.dao.PatientDAO;
import com.healthcare.models.Patient;

import java.util.List;

public class PatientService {
    private PatientDAO patientDAO = new PatientDAO();

    // Business logic for adding a new patient
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);  // Delegate to DAO for adding patient to the database
    }

    // Business logic for retrieving all patients
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();  // Delegate to DAO to get all patients
    }
}
