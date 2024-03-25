package com.security.app_security.services;

import com.security.app_security.models.dto.PersonResponse;

import java.util.List;

public interface ManagerService {
    List<PersonResponse> people();
}
