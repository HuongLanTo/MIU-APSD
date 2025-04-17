package lab7.controller;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class DentistController {
    private final DentistService dentistService;

    @GetMapping("/dentists")
    public List<Dentist> getAllDentists() {
        return dentistService.getAllDentists();
    }
}