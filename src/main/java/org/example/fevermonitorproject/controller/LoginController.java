package org.example.fevermonitorproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin // Allow Vue frontend
public class LoginController {


    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserLoginRequest request) {
        if ("user".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            // Mocked token response
            return ResponseEntity.ok("{ \"token\": \"mock-token\" }");
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }
}
