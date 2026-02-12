package com.example.University.Portal.Crud_Operation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/signup")
public class SignupPost {
    @PostMapping("/stuSignup")
    public String student_signup(@RequestBody String entity) {
        return entity;
    }
    

// teacher signup
    @PostMapping("/techSignup")
    public String teacher_signup(@RequestBody String entity) {
        return entity;
    }
}
