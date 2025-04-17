package lab7.controller;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class SurgeryController {
    private final SurgeryService surgeryService;

    @GetMapping("/surgeries")
    public List<Surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }
}
