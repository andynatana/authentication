package com.andy.authentication.controllers;


import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;
import com.andy.authentication.service.auth.AuthenticationService;
import com.andy.authentication.ws.LoginRequest;
import com.andy.authentication.ws.WSResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class LoginController {

    private final AuthenticationService authenticationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public WSResponse login(@RequestBody LoginRequest loginRequest) throws UserNotFoundException {
        log.info("User with mail {} is trying to connect to the application ", loginRequest.mail());
        User user = authenticationService.authenticate(loginRequest.mail(), loginRequest.password());
        log.info("User {} identified and connected to the application ", user.getFullName());
        return new WSResponse(HttpStatus.OK.value(),"Logged in successfully!", user);
    }
}
