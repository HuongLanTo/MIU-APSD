package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Appointment;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository.AppointmentRepository;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    @Override
    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<Appointment> findAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getAppointmentDate().equals(date))
                .toList();
    }

    @Override
    public List<Appointment> findAppointmentsByDentistNo(String dentistNo) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getDentist().getDentistNo().equals(dentistNo))
                .toList();
    }


} 