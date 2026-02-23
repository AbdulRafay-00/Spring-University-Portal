package com.example.University.Portal.DB_Recorces;

public class StudentStructure {

    private String email;

    private String password;


    private String stuName;

    private int age;

    private String stuPhone;


// constructor
    public StudentStructure() {}
    public StudentStructure(String email, String password, String stuName, int age, String stuEmail, String stuPhone) {
        this.email = email;
        this.password = password;
        this.stuName = stuName;
        this.age = age;
        this.stuPhone = stuPhone;
    }

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

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }


}
