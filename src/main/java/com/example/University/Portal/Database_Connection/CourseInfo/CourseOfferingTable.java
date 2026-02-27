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
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_Id")
    private TeacherInfo teacherInfo;

    @NonNull
    private int sessionYear;

    @NonNull
    private String sessionSemester;


    @NonNull
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_Id")
    private CourseTable courseTable;


}
