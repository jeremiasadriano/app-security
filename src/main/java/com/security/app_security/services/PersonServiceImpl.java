package com.security.app_security.services;

import com.security.app_security.models.Person;
import com.security.app_security.models.Roles;
import com.security.app_security.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Person createPerson(Person person) {
        Optional<Person> model = this.personRepository.findPersonByEmail(person.getEmail());
        if (model.isPresent()) throw new IndexOutOfBoundsException();
        person.setPassword(this.passwordEncoder.encode(person.getPassword()));
        person.setRoles(Roles.USER);
        return this.personRepository.save(person);
    }

    @Override
    public Person findPerson(Long id) {
        return this.personRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public Person findPersonByEmail(String email) {
        if (email.isEmpty()) throw new NullPointerException("Email null");
        return this.personRepository.findPersonByEmail(email).orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public Person updatePerson(Person person, Long id) {
        if (person == null) throw new NullPointerException();
        Person model = findPerson(id);
        if (!person.getName().isEmpty()) model.setName(person.getName());
        if (!person.getEmail().isEmpty()) model.setEmail(person.getEmail());
        if (!person.getPassword().isEmpty()) model.setPassword(this.passwordEncoder.encode(person.getPassword()));
        return this.personRepository.save(model);
    }

    @Override
    public List<Person> listPeople() {
        return this.personRepository.findAll();
    }
}
