package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Patient;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository.PatientRepository;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.PatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientByPatNo(String patNo) {
        return patientRepository.findById(patNo);
    }

    @Override
    public Patient addNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientByPatNo(String patNo) {
        patientRepository.deleteById(patNo);
    }

    @Override
    public Optional<Patient> findPatientByPatName(String patName) {
        return patientRepository.findAll().stream()
                .filter(p -> p.getPatName().equalsIgnoreCase(patName))
                .findFirst();
    }
} 