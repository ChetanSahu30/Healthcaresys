-- Create the database
CREATE DATABASE IF NOT EXISTS healthcare_db;

-- Use the database
USE healthcare_db;

-- Create the patients table
CREATE TABLE IF NOT EXISTS patients (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Create the doctors table
CREATE TABLE IF NOT EXISTS doctors (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

-- Create the appointments table
CREATE TABLE IF NOT EXISTS appointments (
    id INT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

-- Insert patients
INSERT INTO patients (id, name, email) VALUES
(1, 'John Doe', 'john.doe@example.com'),
(2, 'Jane Smith', 'jane.smith@example.com');

-- Insert doctors
INSERT INTO doctors (id, name, specialization) VALUES
(1, 'Dr. Alice', 'Cardiology'),
(2, 'Dr. Bob', 'Neurology');

-- Insert appointments (ensure patient_id and doctor_id exist)
INSERT INTO appointments (id, patient_id, doctor_id, appointment_date) VALUES
(1, 1, 1, '2024-12-27 10:00:00'),
(2, 2, 2, '2024-12-28 11:00:00');

