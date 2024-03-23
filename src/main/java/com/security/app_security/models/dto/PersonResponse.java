package com.security.app_security.models.dto;

import com.security.app_security.models.Person;

public record PersonResponse(Long id, String name, String email) {
    public PersonResponse(Person person) {
        this(person.getId(), person.getName(), person.getEmail());
    }
}
