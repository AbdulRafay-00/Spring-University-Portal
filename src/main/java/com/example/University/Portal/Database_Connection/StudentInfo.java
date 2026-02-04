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
    private  int age;

    @Column()
    private String stuEmail;

    @Column()
    private String stuPhone;

// constructor
    StudentInfo(){}
    
    StudentInfo(String name, int age, String email, String phone){
        this.stuName = name;
        
    }
}
