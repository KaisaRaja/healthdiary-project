package org.example.fevermonitorproject.controller;

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
        Long userId = userService.login(request);

        if (userId != null) {
            Map<String, String> response = new HashMap<>();
            response.put("userId", String.valueOf(userId));
            response.put("token", "mock-token");
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body("Invalid username or password");
    }
}