package com.andy.authentication.ws.advices;

import com.andy.authentication.exceptions.UserNotFoundException;
import com.andy.authentication.ws.WSResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
public class GeneralControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<WSResponse> handleUserNotFoundException(UserNotFoundException exception) {
        WSResponse wsResponse = new WSResponse(UNAUTHORIZED.value(), exception.getMessage(), null);
        return new ResponseEntity<>(wsResponse, UNAUTHORIZED);
    }
}
