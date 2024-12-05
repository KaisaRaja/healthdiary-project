package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.User;
import org.example.fevermonitorproject.model.UserLoginRequest;
import org.example.fevermonitorproject.repository.UserRepository;
import org.example.fevermonitorproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginRequest request) {
        User user = userService.login(request); // Replace with your login logic

        if (user != null) {
            Map<String, User> response = new HashMap<>();
            response.put("user", user);
            return ResponseEntity.ok(response); // Spring converts Map to JSON
        }

        return ResponseEntity.status(401).body("Invalid username or password");
    }
}