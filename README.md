# Online Healthcare Management System

## Overview

The Online Healthcare Management System is a web-based application designed to streamline healthcare processes. It enables users to manage patients, doctors, and appointments. The system connects users with doctors, allowing for appointment scheduling, tracking, and management.

## Features

- **Patient Management**: Add, update, and manage patient information.
- **Doctor Management**: Add and manage doctors, their specialties, and availability.
- **Appointment Scheduling**: Schedule, view, and manage appointments between patients and doctors.
- **Database**: Uses a MySQL database to store patient, doctor, and appointment data.

## Technologies Used

- **Java**: Core programming language for the application.
- **MySQL**: Relational database used to store data for patients, doctors, and appointments.
- **JDBC**: Java Database Connectivity for connecting the Java application to the MySQL database.
- **SQL**: For querying and managing the database.

## Setup Instructions

### Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or above
- **MySQL**: A running instance of MySQL Server.
- **IDE**: Any Java IDE like IntelliJ IDEA, Eclipse, or NetBeans.

### Steps to Run the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Kartik7011/OnlineHealthcareManagementSystem.git
Database Setup:

Create a MySQL database called healthcare_db (if not already created).
Run the resources/database_script.sql script to create necessary tables and seed initial data.
Example to create the database:

sql
CREATE DATABASE healthcare_db;
Then execute the script:

sql

SOURCE path_to_script/database_script.sql;
Configure Database Connection:

Open src/com/healthcare/database/DatabaseConnection.java.
Update the DATABASE_URL, USER, and PASSWORD constants with your MySQL credentials.
Example:

java
private static final String URL = "jdbc:mysql://localhost:3306/healthcare_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
Run the Application:

Navigate to the src/com/healthcare/Main.java file and run the main() method to start the application.
Example Usage
Once the application is running, it will initialize the database and print the following:


Welcome to the Online Healthcare Management System
Database initialized successfully!
You can then interact with the system by adding patients, doctors, and scheduling appointments via the application's user interface.

Project Structure
OnlineHealthcareManagementSystem/
├── src/
│   ├── com/
│   │   ├── healthcare/
│   │   │   ├── Main.java
│   │   │   ├── database/
│   │   │   │   ├── DatabaseConnection.java
│   │   │   ├── dao/
│   │   │   │   ├── PatientDAO.java
│   │   │   ├── models/
│   │   │       ├── Patient.java
│   │   │       ├── Doctor.java
│   │   │       ├── Appointment.java
├── resources/
│   ├── database_script.sql
├── lib/
│   ├── mysql-connector-j-9.1.0

Future Improvements
Add a graphical user interface (GUI) for better user interaction.
Implement authentication and authorization for different user roles (admin, doctor, patient).
Extend the functionality to allow users to book online consultations.


Author: CTRL_ALT_DELETE TEAM
