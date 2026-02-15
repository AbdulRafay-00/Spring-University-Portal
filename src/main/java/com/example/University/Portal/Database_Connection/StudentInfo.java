package com.example.University.Portal.Database_Connection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity()

public class StudentInfo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    @Id
    private long StuId;

    @Column()
    private String stuName;

    @Column()
    private int age;

    @Column(unique = true)
    private String stuEmail;

    @Column()
    private String stuPhone;

    @Column(unique = true)
    private String studentCode;

    @Column(nullable = false)
    private int joiningYear;

    @OneToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "userId")
    LoginInfo loginInfo;

    // constructor
    public StudentInfo() {
    }

    // getter setter

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public void setloginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setStudentCode(String code) {
        this.studentCode = code;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setJoiningYear(int year){
        this.joiningYear = year;
    }

    public int getJoiningYear(){
        return joiningYear;
    }
}
