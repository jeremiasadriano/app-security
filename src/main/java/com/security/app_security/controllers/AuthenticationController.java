package com.security.app_security.controllers;

import com.security.app_security.models.dto.AuthenticationRequest;
import com.security.app_security.models.dto.AuthenticationResponse;
import com.security.app_security.models.dto.PersonRegister;
import com.security.app_security.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid PersonRegister register) {
        return new ResponseEntity<>(this.authenticationService.register(register), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return new ResponseEntity<>(this.authenticationService.login(request), HttpStatus.OK);
    }
}
