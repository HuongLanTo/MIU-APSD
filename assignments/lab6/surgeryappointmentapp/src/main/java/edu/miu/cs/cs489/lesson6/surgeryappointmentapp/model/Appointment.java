package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "pat_no")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_no")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "surgery_no")
    private Surgery surgery;
} 