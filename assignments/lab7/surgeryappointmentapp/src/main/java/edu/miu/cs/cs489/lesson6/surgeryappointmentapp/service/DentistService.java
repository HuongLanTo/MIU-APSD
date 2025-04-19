package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Dentist;

public interface DentistService {
    List<Dentist> getAllDentists();
    Optional<Dentist> getDentistByDentistNo(String dentistNo);
    Dentist addNewDentist(Dentist dentist);
    Dentist updateDentist(Dentist dentist);
    void deleteDentistByDentistNo(String dentistNo);
    Optional<Dentist> findDentistByDentistName(String dentistName);
} 