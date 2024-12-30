package com.healthcare.dao;

import com.healthcare.database.DatabaseConnection;
import com.healthcare.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

public class UserDAOTest {

    private UserDAO userDAO;
    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws SQLException {
        userDAO = new UserDAO();

        // Mock database connection and prepared statement
        mockConnection = mock(Connection.class);
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // When we get the mock connection, return the mock prepared statement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);

        // Simulate a user in the result set
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("username")).thenReturn("testuser");
        when(mockResultSet.getString("password")).thenReturn("testpassword");

        // Mock the DatabaseConnection to return the mock connection
        DatabaseConnection.setConnection(mockConnection);
    }

    @Test
    public void testGetUserByUsernameAndPassword() {
        String username = "testuser";
        String password = "testpassword";

        // Call the method under test
        User user = userDAO.getUserByUsernameAndPassword(username, password);

        // Verify the user object is not null and the user data matches the expected values
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("testpassword", user.getPassword());
    }
}
