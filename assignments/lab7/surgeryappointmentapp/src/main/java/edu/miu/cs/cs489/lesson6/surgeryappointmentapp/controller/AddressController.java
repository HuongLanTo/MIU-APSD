package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.controller;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.Address;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }
}