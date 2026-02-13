package com.example.University.Portal.DB_Recorces;

public class TeachetStructure {

    // Login Info
    private String email;
    private String password;

    // Teacher Profile Info
    private String techName;
    private int age;
    private String techPhone;

    // Constructors
    public TeachetStructure() {}

    public TeachetStructure(String email, String password, String techName, int age, String techPhone) {
        this.email = email;
        this.password = password;
        this.techName = techName;
        this.age = age;
        this.techPhone = techPhone;
    }

    // Getters & Setters
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

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTechPhone() {
        return techPhone;
    }

    public void setTechPhone(String techPhone) {
        this.techPhone = techPhone;
    }
}


