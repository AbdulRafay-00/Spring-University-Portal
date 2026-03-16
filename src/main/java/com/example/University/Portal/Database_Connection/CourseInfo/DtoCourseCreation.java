package com.example.University.Portal.Database_Connection.CourseInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCourseCreation {
    private String courseName;
    private String courseId;
    private String Department;
    private String creditHour;
    private int semester;


}