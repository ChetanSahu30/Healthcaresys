package com.healthcare.utils;

import com.healthcare.models.User;
import com.healthcare.models.Doctor;
import com.healthcare.models.Patient;

public class TestDataUtils {

    // Creates a dummy User for testing
    public static User createDummyUser() {
        return new User(1, "testuser", "password123", "testuser@example.com");
    }

    // Creates a dummy Doctor for testing
    public static Doctor createDummyDoctor() {
        return new Doctor(1, "Dr. John Doe", "Cardiology");
    }

    // Creates a dummy Patient for testing
    public static Patient createDummyPatient() {
        return new Patient(1, "Jane Doe", "janedoe@example.com");
    }
}
