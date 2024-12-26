package com.healthcare;

import com.healthcare.database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Online Healthcare Management System");
        DatabaseConnection.initializeDatabase();
    }
}
