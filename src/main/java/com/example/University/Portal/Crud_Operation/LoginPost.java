package com.example.University.Portal.Crud_Operation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.services.LoginServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
public class LoginPost {

    @Autowired
    LoginServices loginServices;

    @PostMapping("/portal")
    public String user_login(@RequestBody LoginInfo loginInfo) {
        //TODO: process POST request
        
        return loginServices.verifyCredential(loginInfo);
    }
    
    
}
