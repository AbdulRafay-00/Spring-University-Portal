// package com.example.University.Portal.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.University.Portal.DB_Recorces.StudentStructure;
// import com.example.University.Portal.DB_Recorces.TeachetStructure;
// import com.example.University.Portal.Database_Connection.LoginInfo;
// import com.example.University.Portal.Database_Connection.StudentInfo;
// import com.example.University.Portal.Database_Connection.TeacherInfo;
// import com.example.University.Portal.ExtraServices.RoleClass;
// import com.example.University.Portal.Repository.AuthRepository;
// import com.example.University.Portal.Repository.StuDetailRepository;
// import com.example.University.Portal.Repository.TeacherDetailRepository;

// @Service
// public class SignUpServices {

//     private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//     @Autowired
//     AuthRepository authRepository;
//     @Autowired
//     StuDetailRepository stuDetailRepository;
//     @Autowired
//     TeacherDetailRepository teacherInfo;

//     public String verifyUser(StudentStructure entity, RoleClass role) {
//         if (authRepository.findByEmail(entity.getEmail()).isPresent()) {
//             return "User already exists";
//         } else {
//             LoginInfo loginInfo = new LoginInfo();
//             loginInfo.setEmail(entity.getEmail());
//             loginInfo.setPassword(encoder.encode(entity.getPassword()));
//             loginInfo.setRole(role);

//             if (role == role.STUDENT) {
//                 StudentInfo studentInfo = new StudentInfo();

//                 loginInfo.setStudentInfo(studentInfo);

//                 studentInfo.setStuName(entity.getStuName());
//                 studentInfo.setAge(entity.getAge());
//                 studentInfo.setStuEmail(entity.getEmail());
//                 studentInfo.setStuPhone(entity.getStuPhone());
//                 studentInfo.setloginInfo(loginInfo);
//             }

//             if (role == role.TEACHER) {

//                 TeachetStructure teacherInfo = new TeachetStructure();
//                 teacherInfo.setTechName(entity.);
//                 teacherInfo.setAge(t.getAge());
//                 teacherInfo.setTechPhone(t.getTechPhone());
//                 teacherInfo.setTechEmail(t.getEmail()); // email stored here too

//                 // Link teacher to login
//                 teacherInfo.setLoginInfo(loginInfo);
//                 loginInfo.setteacherInfo(teacherInfo);
//             }

//             authRepository.save(loginInfo);
//             // stuDetailRepository.save(studentInfo); error due to cascade type all in login
//             // info entity
//             return "User registered";
//         }
//     }
// }

























package com.example.University.Portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.University.Portal.DB_Recorces.StudentStructure;
import com.example.University.Portal.DB_Recorces.TeachetStructure;
import com.example.University.Portal.Database_Connection.LoginInfo;
import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.TeacherInfo;
import com.example.University.Portal.ExtraServices.RoleClass;
import com.example.University.Portal.Repository.AuthRepository;
import com.example.University.Portal.Repository.StuDetailRepository;
import com.example.University.Portal.Repository.TeacherDetailRepository;

@Service
public class SignUpServices {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    AuthRepository authRepository;

    @Autowired
    StuDetailRepository stuDetailRepository;

    @Autowired
    TeacherDetailRepository teacherInfo;

// STUDENT VERIFICATION
    public String verifyStudent(StudentStructure entity) {
        return verifyUser(entity, RoleClass.STUDENT);
    }

// TEACHER VERIFICATION
    public String verifyTeacher(TeachetStructure entity) {
        return verifyUser(entity, RoleClass.TEACHER);
    }


    private String verifyUser(Object entity, RoleClass role) {

        String email = null;
        if (role == RoleClass.STUDENT) {
            email = ((StudentStructure) entity).getEmail();
        } else if (role == RoleClass.TEACHER) {
            email = ((TeachetStructure) entity).getEmail();
        }

        
// Check  user exists
        if (authRepository.findByEmail(email).isPresent()) {
            return "User already exists";
        }

        LoginInfo loginInfo = new LoginInfo();

        loginInfo.setEmail(email);

        if (role == RoleClass.STUDENT) {
            loginInfo.setPassword(encoder.encode(((StudentStructure) entity).getPassword()));
        } else if (role == RoleClass.TEACHER) {
            loginInfo.setPassword(encoder.encode(((TeachetStructure) entity).getPassword()));
        }

        loginInfo.setRole(role);

        // ---------------- STUDENT ----------------
        if (role == RoleClass.STUDENT) {
            StudentStructure s = (StudentStructure) entity;

            StudentInfo studentInfo = new StudentInfo();

            studentInfo.setStuName(s.getStuName());
            studentInfo.setAge(s.getAge());
            studentInfo.setStuEmail(s.getEmail());
            studentInfo.setStuPhone(s.getStuPhone());

            studentInfo.setloginInfo(loginInfo);
            loginInfo.setStudentInfo(studentInfo);
        }

        // ---------------- TEACHER ----------------
        if (role == RoleClass.TEACHER) {
            TeachetStructure t = (TeachetStructure) entity;

            TeacherInfo teacherInfo = new TeacherInfo();

            teacherInfo.setTechName(t.getTechName());
            teacherInfo.setAge(t.getAge());
            teacherInfo.setTechPhone(t.getTechPhone());
            teacherInfo.setTechEmail(t.getEmail());

            // Link teacher and login
            teacherInfo.setLoginInfo(loginInfo);
            loginInfo.setteacherInfo(teacherInfo);
        }

        // Save login info (cascade saves profile)
        authRepository.save(loginInfo);

        return "User registered";
    }
}
