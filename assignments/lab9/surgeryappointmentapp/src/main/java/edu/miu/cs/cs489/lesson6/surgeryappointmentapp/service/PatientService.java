package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Patient;

public interface PatientService {
    List<Patient> getAllPatients();
    Optional<Patient> getPatientByPatientId(String patientId);
    public Patient savePatient(Patient patient);
    public Patient updatePatient(String patientId, Patient patientDetails);
    public void deletePatient(String patientId);
    public List<Patient> searchPatients(String searchString);
}