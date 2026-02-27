package com.example.University.Portal.Database_Connection.CourseInfo;

import java.sql.Date;

import com.example.University.Portal.Database_Connection.TeacherInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class CourseOfferingTable {

    @Id
    private long id;

    @NonNull
    private String courseOfferingId;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "teacher_Id", referencedColumnName = "teacherId")
    private TeacherInfo teacherInfo;

    @NonNull
    private int sessionYear;

    @NonNull
    private String sessionSemester;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "course_Id", referencedColumnName = "courseId")
    private CourseTable courseTable;


}
