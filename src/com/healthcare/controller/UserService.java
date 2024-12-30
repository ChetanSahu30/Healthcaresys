package com.healthcare.services;

import com.healthcare.dao.UserDAO;
import com.healthcare.models.User;

public class UserService {

    private UserDAO userDAO = new UserDAO(); // DAO for database operations

    // Method to authenticate user
    public User authenticateUser(String username, String password) {
        return userDAO.getUserByUsernameAndPassword(username, password);
    }
}
