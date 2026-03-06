package com.siaproject.backend.service;
import com.siaproject.backend.dto.RegisterDTO;
import com.siaproject.backend.entity.User;
import com.siaproject.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User register(RegisterDTO data) {
        if (!data.getUserPassword().equals(data.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match!");
        }

        if (userRepository.existsByUserEmail(data.getUserEmail())) {
            throw new RuntimeException("Email is already taken!");
        }

        User newUser = new User();
        newUser.setUserEmail(data.getUserEmail());
        newUser.setUserFirstname(data.getUserFirstName());
        newUser.setUserLastname(data.getUserLastName());
        String encodedPassword = passwordEncoder.encode(data.getUserPassword());
        newUser.setUserPassword(encodedPassword);

        return userRepository.save(newUser);
    }
}