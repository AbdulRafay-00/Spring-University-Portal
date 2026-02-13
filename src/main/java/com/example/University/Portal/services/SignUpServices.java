package com.example.University.Portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.University.Portal.DB_Recorces.StudentStructure;
import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.ExtraServices.RoleClass;
import com.example.University.Portal.Repository.AuthRepository;
import com.example.University.Portal.Repository.StuDetailRepository;

@Service
public class SignUpServices {
    
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    AuthRepository authRepository;
    @Autowired
    StuDetailRepository stuDetailRepository;

    public String verifyUser(StudentStructure entity , RoleClass roleClass) {
        if(authRepository.findByEmail(entity.getEmail()).isPresent()) {
            return "User already exists";
        }else {
            StudentInfo studentInfo = new StudentInfo();
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setEmail(entity.getEmail());
            loginInfo.setPassword(encoder.encode(entity.getPassword()));
            loginInfo.setRole("STUDENT");
            loginInfo.setStudentInfo(studentInfo);
            
            studentInfo.setStuName(entity.getStuName());
            studentInfo.setAge(entity.getAge());
            studentInfo.setStuEmail(entity.getEmail());
            studentInfo.setStuPhone(entity.getStuPhone());
            studentInfo.setloginInfo(loginInfo);


            authRepository.save(loginInfo);
            // stuDetailRepository.save(studentInfo);   error due to cascade type all in login info entity
            return "User registered";
        }
    }
}
