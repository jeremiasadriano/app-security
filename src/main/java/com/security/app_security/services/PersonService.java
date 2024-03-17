package com.security.app_security.services;

import com.security.app_security.models.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person findPerson(Long id);
    Person findPersonByEmail(String email);

    Person updatePerson(Person person, Long id);

    List<Person> listPeople();

}
