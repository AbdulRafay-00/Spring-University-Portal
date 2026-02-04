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
    private Long userId;
    @Column(unique = true)
    private String email;
    @Column()
    private String password;
    @Column()
    private String role;

    LoginInfo() {
    }

    LoginInfo(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

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

}
