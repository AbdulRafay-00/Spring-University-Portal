package com.example.University.Portal.Database_Connection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoginInfo")
public class LoginInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    @Id
    private Long userId;
    @Column(unique = true)
    private String email;
    @Column()
    private String password;
    @Column()
    private String role;

    @OneToOne(mappedBy = "loginInfo", cascade = CascadeType.ALL, orphanRemoval =  true)
    StudentInfo studentInfo;

    @OneToOne(mappedBy = "loginInfo", cascade = CascadeType.ALL, orphanRemoval =  true)
    TeacherInfo teacherInfo;

    public LoginInfo() {}


    // Getter And Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void  setStudentInfo (StudentInfo studentInfo){
        this.studentInfo = studentInfo;
    }

    public StudentInfo getStudentInfo(){
        return studentInfo;
    }

    public void setteacherInfo (TeacherInfo teacherInfo){
        this.teacherInfo = teacherInfo;
    }

    public TeacherInfo getTeacherInfo(){
        return teacherInfo;
    }
}
