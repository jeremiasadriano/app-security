package com.security.app_security.security;

import com.security.app_security.models.UserAuth;
import com.security.app_security.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personRepository.findPersonByEmail(username)
                .map(UserAuth::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
    }
}
