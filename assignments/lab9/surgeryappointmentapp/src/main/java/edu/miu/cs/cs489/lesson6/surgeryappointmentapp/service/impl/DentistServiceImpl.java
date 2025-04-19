package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Dentist;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository.DentistRepository;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.DentistService;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Optional<Dentist> getDentistByDentistNo(String dentistNo) {
        return dentistRepository.findById(dentistNo);
    }

    @Override
    public Dentist addNewDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentistByDentistNo(String dentistNo) {
        dentistRepository.deleteById(dentistNo);
    }

    @Override
    public Optional<Dentist> findDentistByDentistName(String dentistName) {
        return dentistRepository.findAll().stream()
                .filter(d -> d.getDentistName().equalsIgnoreCase(dentistName))
                .findFirst();
    }
} 