-- Create Dentist Table
CREATE TABLE Dentist (
    dentist_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100),
    specialization VARCHAR(100)
);

-- Create Patient Table
CREATE TABLE Patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100),
    address TEXT,
    dob DATE
);

-- Create Surgery Table
CREATE TABLE Surgery (
    surgery_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    address TEXT,
    phone VARCHAR(15)
);

-- Create Appointment Table
CREATE TABLE Appointment (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    dentist_id INT,
    surgery_id INT,
    appointment_date DATE,
    appointment_time TIME,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (dentist_id) REFERENCES Dentist(dentist_id),
    FOREIGN KEY (surgery_id) REFERENCES Surgery(surgery_id)
);

-- Create Bill Table
CREATE TABLE Bill (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    amount DECIMAL(10,2),
    is_paid BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);

-- Insert Dentists
INSERT INTO Dentist (first_name, last_name, phone, email, specialization) VALUES
('John', 'Smith', '555-1111', 'john.smith@ads.com', 'Orthodontist'),
('Sarah', 'Miller', '555-2222', 'sarah.miller@ads.com', 'Endodontist');

-- Insert Patients
INSERT INTO Patient (first_name, last_name, phone, email, address, dob) VALUES
('Alice', 'Brown', '555-3333', 'alice.brown@example.com', '123 Elm Street', '1990-06-15'),
('Bob', 'Green', '555-4444', 'bob.green@example.com', '456 Oak Avenue', '1985-02-28');

-- Insert Surgeries
INSERT INTO Surgery (name, address, phone) VALUES
('Downtown Clinic', '10 Main St', '555-5000'),
('Uptown Surgery', '99 High St', '555-6000');

-- Insert Appointments
INSERT INTO Appointment (patient_id, dentist_id, surgery_id, appointment_date, appointment_time) VALUES
(1, 1, 1, '2025-04-08', '10:00:00'),
(2, 1, 2, '2025-04-09', '11:30:00'),
(1, 2, 1, '2025-04-10', '14:00:00');

-- Insert Bills
INSERT INTO Bill (patient_id, amount, is_paid) VALUES
(1, 150.00, FALSE),
(2, 200.00, TRUE);

-- Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames.
SELECT *
FROM Dentist
ORDER BY last_name ASC;

-- Display the list of ALL Appointments for a given Dentist by their dentist_Id number. Include in the result, the Patient information.
SELECT
    Appointment.appointment_id,
    Appointment.appointment_date,
    Appointment.appointment_time,
    Patient.first_name AS patient_first_name,
    Patient.last_name AS patient_last_name,
    Patient.phone AS patient_phone,
    Patient.email AS patient_email
FROM Appointment
JOIN Patient ON Appointment.patient_id = Patient.patient_id
WHERE Appointment.dentist_id = 1;

-- Display the list of ALL Appointments for a given Dentist by their dentist_Id number. Include in the result, the Patient information.
SELECT
    Appointment.appointment_id,
    Appointment.appointment_date,
    Appointment.appointment_time,
    Dentist.first_name AS dentist_first_name,
    Dentist.last_name AS dentist_last_name,
    Patient.first_name AS patient_first_name,
    Patient.last_name AS patient_last_name
FROM Appointment
JOIN Dentist ON Appointment.dentist_id = Dentist.dentist_id
JOIN Patient ON Appointment.patient_id = Patient.patient_id
WHERE Appointment.surgery_id = 1;

-- Display the list of the Appointments booked for a given Patient on a given Date.
SELECT
    Appointment.appointment_id,
    Appointment.appointment_time,
    Dentist.first_name AS dentist_first_name,
    Dentist.last_name AS dentist_last_name,
    Surgery.name AS surgery_name
FROM Appointment
JOIN Dentist ON Appointment.dentist_id = Dentist.dentist_id
JOIN Surgery ON Appointment.surgery_id = Surgery.surgery_id
WHERE Appointment.patient_id = 1
AND Appointment.appointment_date = '2025-04-08';


