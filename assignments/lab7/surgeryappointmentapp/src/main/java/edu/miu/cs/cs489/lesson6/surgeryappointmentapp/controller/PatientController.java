package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.controller;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Patient;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{patientId}")
    public Optional<Patient> getPatient(@PathVariable String patientId) {
        return patientService.getPatientByPatientId(patientId);
    }

    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/patient/{patientId}")
    public Patient updatePatient(@PathVariable String patientId, @RequestBody Patient patient) {
        return patientService.updatePatient(patientId, patient);
    }

    @DeleteMapping("/patient/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable String patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/patient/search/{searchString}")
    public List<Patient> search(@PathVariable String searchString) {
        return patientService.searchPatients(searchString);
    }
}
