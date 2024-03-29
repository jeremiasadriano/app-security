package com.security.app_security.controllers;

import com.security.app_security.models.dto.PersonResponse;
import com.security.app_security.services.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<PersonResponse>> people() {
        return new ResponseEntity<>(this.managerService.people(), HttpStatus.OK);
    }
}
