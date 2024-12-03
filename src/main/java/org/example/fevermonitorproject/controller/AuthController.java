package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.User;
import org.example.fevermonitorproject.model.UserLoginRequest;
import org.example.fevermonitorproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin // Allow Vue frontend
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(request.getPassword())) {
                // Generate a real token (e.g., JWT) here
                return ResponseEntity.ok("{ \"token\": \"mock-token\" }");
            }
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}