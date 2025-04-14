package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Patient;

public interface PatientService {
    List<Patient> getAllPatients();
    Optional<Patient> getPatientByPatNo(String patNo);
    Patient addNewPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatientByPatNo(String patNo);
    Optional<Patient> findPatientByPatName(String patName);
} 