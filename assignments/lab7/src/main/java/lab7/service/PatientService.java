package lab7.service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID " + id));
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient existing = getPatientById(id);
        existing.setFirstName(patientDetails.getFirstName());
        existing.setLastName(patientDetails.getLastName());
        existing.setPrimaryAddress(patientDetails.getPrimaryAddress());
        return patientRepository.save(existing);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> searchPatients(String searchString) {
        return patientRepository.findAll().stream()
                .filter(p -> (p.getFirstName() + " " + p.getLastName()).toLowerCase().contains(searchString.toLowerCase()))
                .toList();
    }
}
