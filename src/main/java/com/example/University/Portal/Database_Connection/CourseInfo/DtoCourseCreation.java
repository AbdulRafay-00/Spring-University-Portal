package com.example.University.Portal.Database_Connection.CourseInfo;


@Data
public class DtoCourseCreation {
    private String courseName;
    private String courseId;
    private String Department;
    private int creditHour;

    public DtoCourseCreation() {
    }

    public DtoCourseCreation(String courseName, String courseCode, String Department, int creditHour) {
        this.courseName = courseName;
        this.courseId = courseCode;
        this.Department = Department;
        this.creditHour = credits;
    }

}