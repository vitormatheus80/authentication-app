package com.authentication.api.exception;

public class LoginErrorException extends RuntimeException{
    public LoginErrorException() {
    }

    public LoginErrorException(String message) {
        super(message);
    }

    public LoginErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
