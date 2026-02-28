package com.example.University.Portal.Database_Connection;

import java.util.List;

import com.example.University.Portal.Database_Connection.CourseInfo.CourseOfferingTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TeacherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column(unique = true)
    private String teacherId;

    @Column
    private String techName;

    @Column
    private int age;

    @Column
    private String techPhone;


    @Column(unique = true)
    private String techEmail;

    @Column(nullable = false)
    private int joiningYear;
    
    @OneToOne
    @JoinColumn(name = "user_Id", referencedColumnName = "userId")
    LoginInfo loginInfo;



// in mapped by give the name of the variable in courseoffering table that is referencing teacher info  like private TeacherInfo teacherId; in course offering table
//     @OneToMany(mappedBy = "teacherId")
// private List<CourseOfferingTable> courseOfferings;

    // constructor
    public TeacherInfo() {
    }

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

    public void setTeacherCode(String code) {
        this.teacherId = code;
    }

    public String getTeacherCode() {
        return teacherId;
    }

    public void setJoiningYear(int year){
        this.joiningYear = year;
    }

    public int getJoiningYear(){
        return joiningYear;
    }

//     public List<CourseOfferingTable> getCourseOfferings() {
//     return courseOfferings;
// }

// public void setCourseOfferings(List<CourseOfferingTable> courseOfferings) {
//     this.courseOfferings = courseOfferings;
// }
}
