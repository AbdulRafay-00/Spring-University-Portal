package com.example.University.Portal.Crud_Operation;

import org.springframework.web.bind.annotation.RestController;

import com.example.University.Portal.DB_Recorces.StudentStructure;
import com.example.University.Portal.DB_Recorces.TeachetStructure;
import com.example.University.Portal.ExtraServices.RoleClass;
import com.example.University.Portal.services.SignUpServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/signup")
public class SignupPost {
    @Autowired
    SignUpServices signUpServices;
    @PostMapping("/stuSignup")
    public String student_signup(@RequestBody StudentStructure entity)  {

        return signUpServices.verifyStudent(entity);
    }
    

// teacher signup
    @PostMapping("/techSignup")
    public String teacher_signup(@RequestBody TeachetStructure entity)  {
        return signUpServices.verifyTeacher(entity);
    }
}
