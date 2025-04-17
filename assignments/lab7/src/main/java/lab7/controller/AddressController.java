package lab7.controller;

import lab7.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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