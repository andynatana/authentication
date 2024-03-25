package com.andy.authentication.service.auth.impl;

import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;
import com.andy.authentication.service.UserService;
import com.andy.authentication.service.auth.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Profile("PROD")
public class SaasService implements AuthenticationService {

    private final UserService userService;

    @Override
    public User authenticate(String mail, String password) throws UserNotFoundException {
        return userService.find(mail, password);
    }
}
