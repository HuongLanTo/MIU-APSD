package lab7.service;

@Service
@RequiredArgsConstructor
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;

    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }
}