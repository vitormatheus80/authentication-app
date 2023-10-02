package com.authentication.api.controller.handlers;
import com.authentication.api.exception.LoginErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthenticationExceptionHandler {


    @ExceptionHandler(LoginErrorException.class)
    public ResponseEntity<String> handleLoginErrorExceptionException(LoginErrorException loginErrorException){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginErrorException.getMessage());
    }

}
