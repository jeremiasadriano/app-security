package com.security.app_security.services;

import com.security.app_security.models.dto.AuthRequest;
import com.security.app_security.models.dto.AuthResponse;
import com.security.app_security.models.dto.PersonRegister;

public interface AuthService {
    AuthResponse register(PersonRegister register);

    AuthResponse login(AuthRequest request);
}
