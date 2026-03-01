package com.example.University.Portal.Exceptions.ExceptionType;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {
        super(message);
    }
    
}
