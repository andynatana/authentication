package com.andy.authentication.controllers;


import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;
import com.andy.authentication.service.auth.AuthenticationService;
import com.andy.authentication.ws.LoginRequest;
import com.andy.authentication.ws.WSResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public WSResponse login(@RequestBody LoginRequest loginRequest) throws UserNotFoundException {
        User user = authenticationService.authenticate(loginRequest.mail(), loginRequest.password());
        return new WSResponse(HttpStatus.OK.value(),"Logged in successfully!", user);
    }
}
