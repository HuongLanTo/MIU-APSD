package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Address;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository.AddressRepository;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll(Sort.by(Sort.Direction.ASC, "city"));
    }
}
