package lab7.service;

@Service
@RequiredArgsConstructor
public class DentistService {
    private final DentistRepository dentistRepository;

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }
}
