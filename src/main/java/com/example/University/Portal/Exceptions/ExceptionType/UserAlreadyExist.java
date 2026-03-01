package com.example.University.Portal.Exceptions.ExceptionType;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String message) {
        super(message);
    }
    
}
