package com.security.app_security.controllers;

import com.security.app_security.models.Person;
import com.security.app_security.models.dto.PersonResponse;
import com.security.app_security.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<PersonResponse> register(@RequestBody Person person) {
        return new ResponseEntity<>(this.adminService.register(person), HttpStatus.CREATED);
    }
}
