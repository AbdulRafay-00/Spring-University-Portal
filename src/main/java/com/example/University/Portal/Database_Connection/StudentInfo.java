package com.example.University.Portal.Database_Connection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    @Column()
    private String stuEmail;

    @Column()
    private String stuPhone;

    // constructor
    StudentInfo() {
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

}
