package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Dentist;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, String> {
} 