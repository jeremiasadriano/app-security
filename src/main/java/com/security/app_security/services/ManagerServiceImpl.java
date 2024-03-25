package com.security.app_security.services;

import com.security.app_security.models.dto.PersonResponse;
import com.security.app_security.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final PersonRepository repository;

    @Override
    public List<PersonResponse> people() {
        return this.repository.findAll()
                .stream().map(PersonResponse::new)
                .collect(Collectors.toList());
    }
}
