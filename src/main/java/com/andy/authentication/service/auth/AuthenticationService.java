package com.andy.authentication.service.auth;

import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;

public interface AuthenticationService {
    User authenticate(String mail, String password) throws UserNotFoundException;
}
