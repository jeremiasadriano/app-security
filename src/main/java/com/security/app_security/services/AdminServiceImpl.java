package com.security.app_security.services;

import com.security.app_security.models.Person;
import com.security.app_security.models.dto.PersonResponse;
import com.security.app_security.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final PersonRepository repository;
    private final PasswordEncoder encoder;

    @Override
    public PersonResponse register(Person person) {
        if (person == null) throw new NullPointerException("Not null");
        person.setPassword(encoder.encode(person.getPassword()));
        return new PersonResponse(this.repository.save(person));
    }
}
