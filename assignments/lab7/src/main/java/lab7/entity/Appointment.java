package lab7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime appointmentDate;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Dentist dentist;

    @ManyToOne
    private Surgery surgery;
}

