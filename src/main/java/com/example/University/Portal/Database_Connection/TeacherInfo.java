package com.example.University.Portal.Database_Connection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class TeacherInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long techId;

    @Column
    private String techName;

    @Column
    private int age;

    @Column
    private String techPhone;

    @Column(unique =  true)
    private String techEmail;
    @OneToOne
    @JoinColumn(name = "user_Id" , referencedColumnName = "userId" )
    LoginInfo loginInfo;
// constructor
    public TeacherInfo(){}

// getter/setter

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

public String getTechEmail() {
    return techEmail;
}

public void setTechEmail(String techEmail) {
    this.techEmail = techEmail;
}

public LoginInfo getLoginInfo() {
    return loginInfo;
}

public void setLoginInfo(LoginInfo loginInfo) {
    this.loginInfo = loginInfo;
}


}
