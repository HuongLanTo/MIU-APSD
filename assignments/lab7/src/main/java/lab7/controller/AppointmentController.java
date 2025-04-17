package lab7.controller;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}
