package com.security.app_security.services;

import com.security.app_security.models.Person;
import com.security.app_security.models.dto.PersonResponse;

public interface AdminService {
    PersonResponse register(Person person);
}
