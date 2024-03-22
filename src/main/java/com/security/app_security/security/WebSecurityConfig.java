package com.security.app_security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final UserServices userServices;
    private final JwtFilter filter;

    @Bean("security_chain")
    public SecurityFilterChain chain(HttpSecurity security) throws Exception {
        return security.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/login/**", "/register/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                ).userDetailsService(userServices)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class) //Before any http request not authenticated he will use this filter(he'll get the token, validate the token, validate the user, he's roles, if he's valid or not, etc.)
                .build();
    }

    @Bean("password_encoder")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean("authentication_manager")
    public AuthenticationManager manager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}