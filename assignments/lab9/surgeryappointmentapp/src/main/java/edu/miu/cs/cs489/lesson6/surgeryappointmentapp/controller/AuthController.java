package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.controller;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.dto.AuthRequestDto;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDto authRequestDto) {
        return null;
    }
}
