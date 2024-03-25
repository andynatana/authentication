package com.andy.authentication.controllers;


import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.models.User;
import com.andy.authentication.service.UserService;
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

    private final UserService userService;

    @PostMapping("/login")
    public WSResponse login(@RequestBody LoginRequest loginRequest) throws UserNotFoundException {
        User user = userService.find(loginRequest.mail(), loginRequest.password());
        return new WSResponse(HttpStatus.OK.value(),"Logged in successfully!", user);
    }
}
