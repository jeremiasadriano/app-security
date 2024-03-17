package com.security.app_security.security;

import com.security.app_security.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personService.findPersonByEmail(username);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        return this.personService.findPerson(id);
    }
}
