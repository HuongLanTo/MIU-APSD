package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Appointment;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long appointmentId);
    Appointment addNewAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointmentById(Long appointmentId);
    List<Appointment> findAppointmentsByDate(LocalDate date);
    List<Appointment> findAppointmentsByDentistNo(String dentistNo);
    List<Appointment> findAppointmentsByPatientNo(String patNo);
} 