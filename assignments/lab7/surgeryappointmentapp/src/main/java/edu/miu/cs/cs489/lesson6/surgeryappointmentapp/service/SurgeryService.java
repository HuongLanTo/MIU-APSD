package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Surgery;

public interface SurgeryService {
    List<Surgery> getAllSurgeries();
    Optional<Surgery> getSurgeryBySurgeryNo(String surgeryNo);
    Surgery addNewSurgery(Surgery surgery);
    Surgery updateSurgery(Surgery surgery);
    void deleteSurgeryBySurgeryNo(String surgeryNo);
    Optional<Surgery> findSurgeryByName(String name);
} 