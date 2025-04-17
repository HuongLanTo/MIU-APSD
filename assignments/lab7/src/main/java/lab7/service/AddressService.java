package lab7.service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
    }
}
