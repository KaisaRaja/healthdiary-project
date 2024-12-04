package org.example.fevermonitorproject.controller;

import org.example.fevermonitorproject.model.UserLoginRequest;
import org.example.fevermonitorproject.repository.UserRepository;
import org.example.fevermonitorproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin // Allow Vue frontend
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {

        boolean access = userService.login(request);
        if (access) {
            return ResponseEntity.ok("{ \"token\": \"mock-token\" }");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}