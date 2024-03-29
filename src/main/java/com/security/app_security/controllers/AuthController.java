package com.security.app_security.controllers;

import com.security.app_security.models.dto.AuthRequest;
import com.security.app_security.models.dto.AuthResponse;
import com.security.app_security.models.dto.PersonRegister;
import com.security.app_security.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid PersonRegister register) {
        return new ResponseEntity<>(this.authService.register(register), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        return new ResponseEntity<>(this.authService.login(request), HttpStatus.OK);
    }
}
