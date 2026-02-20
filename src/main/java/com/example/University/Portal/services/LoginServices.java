package com.example.University.Portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.University.Portal.Database_Connection.LoginInfo;

public class LoginServices  {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    private String verifyCredential( LoginInfo loginInfo){
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginInfo.getEmail(), loginInfo.getPassword())
            );
        } catch (Exception e) {
            return "Invalid email or password";
        }
        return "";
    }
}
