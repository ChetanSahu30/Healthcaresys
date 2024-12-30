package com.healthcare.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    // Validates if the given email follows a proper email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validates if the given password meets complexity requirements
    public static boolean isValidPassword(String password) {
        // Password should have at least 8 characters, 1 uppercase, 1 number, 1 special character
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
        return password.matches(passwordRegex);
    }
}
