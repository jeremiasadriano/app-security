package com.security.app_security.services;

import com.security.app_security.models.Person;
import com.security.app_security.models.Roles;
import com.security.app_security.models.dto.AuthenticationRequest;
import com.security.app_security.models.dto.AuthenticationResponse;
import com.security.app_security.models.dto.PersonRegister;
import com.security.app_security.models.dto.PersonResponse;
import com.security.app_security.repositories.PersonRepository;
import com.security.app_security.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PersonRepository personRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(PersonRegister register) {
        if (register == null || register.name().isEmpty()) throw new NullPointerException("Null values not allowed!");
        Person person = new Person(register.name(), register.email(), this.passwordEncoder.encode(register.password()), Roles.USER);
        return new AuthenticationResponse(this.jwtService.generateToken(register.email()), new PersonResponse(this.personRepository.save(person)));
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        Person person = this.personRepository.findPersonByEmail(request.email()).orElseThrow(NullPointerException::new);
        return new AuthenticationResponse(this.jwtService.generateToken(request.email()), new PersonResponse(person));
    }
}
