package com.andy.authentication.service;


import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;
import com.andy.authentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User find(String mail, String password) throws UserNotFoundException {
        return userRepository.findByMailAndPassword(mail, password)
                .orElseThrow(() -> new UserNotFoundException("Mail or password are wrong !"));
    }
}
