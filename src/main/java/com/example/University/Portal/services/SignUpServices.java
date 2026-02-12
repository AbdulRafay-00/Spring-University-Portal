package com.example.University.Portal.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.University.Portal.DB_Recorces.StudentStructure;
import com.example.University.Portal.Repository.AuthRepository;

public class SignUpServices {
    @Autowired
    AuthRepository authRepository;

    public String verifyUser(StudentStructure entity) {
        if(authRepository.findByEmail(entity.getEmail()).isPresent()) {
            return "User already exists";
        }else {
            return "User can be registered";
        }

        // return "";
    }
}
