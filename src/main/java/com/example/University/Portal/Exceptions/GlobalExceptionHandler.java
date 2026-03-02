package com.example.University.Portal.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.University.Portal.Exceptions.ExceptionType.UserAlreadyExist;
import com.example.University.Portal.Exceptions.ExceptionType.UserNotFound;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
}


    // user Already exist error
    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<String> handleUserAlreadyExists(UserAlreadyExist ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }


// bad request send
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <HashMap<String, String>> handleMethodArgumentNotValidExException(MethodArgumentNotValidException ex){

        HashMap <String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
    });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errors);
    }
}
