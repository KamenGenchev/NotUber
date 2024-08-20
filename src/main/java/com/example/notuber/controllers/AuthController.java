package com.example.notuber.controllers;

import com.example.notuber.dtos.UserLoginDTO;
import com.example.notuber.dtos.UserRegisterDTO;
import com.example.notuber.security.JwtUtil;
import com.example.notuber.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthService service, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.authService = service;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterDTO dto) {
        authService.registerUser(dto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDTO dto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.email(), dto.password())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(createJwtResponse(dto.email(), authentication.getPrincipal()));
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }

    private Map<String, Object> createJwtResponse(String email, Object principal) {
        String jwt = jwtUtil.generateToken(email);
        Map<String, Object> response = new HashMap<>();
        response.put("jwt", jwt);
        response.put("user", principal);
        return response;
    }
}
