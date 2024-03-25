package com.andy.authentication.controllers;


import com.andy.authentication.ws.LoginRequest;
import com.andy.authentication.ws.WSResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public WSResponse login(LoginRequest loginRequest) {
        return new WSResponse(HttpStatus.OK.value(),"Logged in successfully!", null);
    }
}
