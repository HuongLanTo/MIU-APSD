package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
