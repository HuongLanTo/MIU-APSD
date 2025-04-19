package edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.impl;

import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.config.JwtUtil;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.model.User;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.repository.UserRepository;
import edu.miu.cs.cs489.lesson6.surgeryappointmentapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public String login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        var user = userRepository.findByUsername(username).orElseThrow();
        return jwtUtil.generateToken((UserDetails) user);
    }
}
