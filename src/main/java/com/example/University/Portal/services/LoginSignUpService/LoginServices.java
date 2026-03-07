package com.example.University.Portal.services.LoginSignUpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.services.JwtServices.JwtServices;

@Service
public class LoginServices  {

    @Autowired
    private JwtServices jwtServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    public String verifyCredential( LoginInfo loginInfo){
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginInfo.getEmail(), loginInfo.getPassword())
            );
        } catch (Exception e) {
            return "Invalid email or password";
        }
        return jwtServices.jwt_token_gen(loginInfo);
    }
}
