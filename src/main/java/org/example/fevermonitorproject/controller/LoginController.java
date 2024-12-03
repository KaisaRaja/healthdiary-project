package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.User;
import org.example.fevermonitorproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin // Allow Vue frontend
public class LoginController {
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        User user = UserRepository.findByUsername(request.getUsername());

        if (user != null && user.getPassword().equals(request.getPassword())) {
            // Generate a real token (e.g., JWT) here
            return ResponseEntity.ok("{ \"token\": \"mock-token\" }");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}