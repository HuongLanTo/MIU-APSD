package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Surgery;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository.SurgeryRepository;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.SurgeryService;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;

    @Override
    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    @Override
    public Optional<Surgery> getSurgeryBySurgeryNo(String surgeryNo) {
        return surgeryRepository.findById(surgeryNo);
    }

    @Override
    public Surgery addNewSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery updateSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public void deleteSurgeryBySurgeryNo(String surgeryNo) {
        surgeryRepository.deleteById(surgeryNo);
    }

    @Override
    public Optional<Surgery> findSurgeryByName(String name) {
        return surgeryRepository.findAll().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }
} 