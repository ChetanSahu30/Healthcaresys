package com.healthcare.utils;

import static org.junit.Assert.*;

import com.healthcare.models.User;

public class AssertionUtils {

    // Asserts that two User objects are equal
    public static void assertUserEquals(User expected, User actual) {
        assertEquals("User ID mismatch", expected.getId(), actual.getId());
        assertEquals("User name mismatch", expected.getName(), actual.getName());
        assertEquals("User email mismatch", expected.getEmail(), actual.getEmail());
    }
}
