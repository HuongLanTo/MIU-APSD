package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
        return patientRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    @Override
    public Optional<Patient> getPatientByPatientId(String patientId) {
        return Optional.ofNullable(patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID " + patientId)));
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(String patientId, Patient patientDetails) {
        Optional<Patient> existing = getPatientByPatientId(patientId);
        if (existing.isPresent()) {
            Patient patient = existing.get();
            patient.setFirstName(patientDetails.getFirstName());
            patient.setLastName(patientDetails.getLastName());
            patient.setAddress(patientDetails.getAddress());
            return patientRepository.save(patient);
        }
        return null;
    }

    public void deletePatient(String patientId) {
        patientRepository.deleteById(patientId);
    }

    public List<Patient> searchPatients(String searchString) {
        return patientRepository.findAll().stream()
                .filter(p -> (p.getFirstName() + " " + p.getLastName()).toLowerCase().contains(searchString.toLowerCase()))
                .toList();
    }
} 