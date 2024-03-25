package com.andy.authentication.service.auth.impl;

import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;
import com.andy.authentication.service.auth.AuthenticationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("TEST")
public class DefaultService implements AuthenticationService {
    @Override
    public User authenticate(String mail, String password) throws UserNotFoundException {
        return new User();
    }
}
