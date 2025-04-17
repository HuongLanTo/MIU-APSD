package lab7.controller;

import lab7.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/patient/search/{searchString}")
    public List<Patient> search(@PathVariable String searchString) {
        return patientService.searchPatients(searchString);
    }
}
