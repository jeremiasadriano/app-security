package com.security.app_security.services;

import com.security.app_security.models.dto.AuthenticationRequest;
import com.security.app_security.models.dto.AuthenticationResponse;
import com.security.app_security.models.dto.PersonRegister;

public interface AuthenticationService {
    AuthenticationResponse register(PersonRegister register);

    AuthenticationResponse login(AuthenticationRequest request);
}
