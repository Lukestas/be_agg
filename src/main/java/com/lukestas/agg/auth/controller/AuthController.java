package com.lukestas.agg.auth.controller;

import com.lukestas.agg.auth.DTO.LoginRequest;
import com.lukestas.agg.auth.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody LoginRequest request) {

        String token = authService.login(request);

        return ResponseEntity.ok(
                Map.of("token", token));
    }
}