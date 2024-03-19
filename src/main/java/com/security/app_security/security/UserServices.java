package com.security.app_security.security;

import com.security.app_security.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

@Service
@RequiredArgsConstructor
public class UserServices implements UserDetailsService {
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personRepository.findPersonByEmail(username).orElseThrow(() -> new InputMismatchException("Username not found!"));
    }
}
