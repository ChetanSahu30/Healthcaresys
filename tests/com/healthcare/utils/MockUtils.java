package com.healthcare.utils;

import com.healthcare.dao.UserDAO;
import com.healthcare.dao.DoctorDAO;
import com.healthcare.models.User;
import com.healthcare.models.Doctor;
import org.mockito.Mockito;

public class MockUtils {

    // Mocks UserDAO for testing
    public static UserDAO mockUserDAO() {
        UserDAO mockUserDAO = Mockito.mock(UserDAO.class);
        Mockito.when(mockUserDAO.getUserById(1)).thenReturn(new User(1, "testuser", "password123", "testuser@example.com"));
        return mockUserDAO;
    }

    // Mocks DoctorDAO for testing
    public static DoctorDAO mockDoctorDAO() {
        DoctorDAO mockDoctorDAO = Mockito.mock(DoctorDAO.class);
        Mockito.when(mockDoctorDAO.getDoctorById(1)).thenReturn(new Doctor(1, "Dr. John Doe", "Cardiology"));
        return mockDoctorDAO;
    }
}
