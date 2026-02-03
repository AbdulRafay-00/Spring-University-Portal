package com.example.University.Portal.Database_Connection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoginInfo")
public class LoginInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    @Id
    private int Id;
    @Column(unique =  true)
    private String email;
    @Column()
    private String password;
    @Column()
    private String role;


    LoginInfo(){}
    LoginInfo(String email, String password){}

}
