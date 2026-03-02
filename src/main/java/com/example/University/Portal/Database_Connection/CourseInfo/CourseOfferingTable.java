package com.example.University.Portal.Database_Connection.CourseInfo;

import java.sql.Date;

import com.example.University.Portal.Database_Connection.TeacherInfo;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(unique = true)
    private String courseOfferingId;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "teacher_Id", referencedColumnName = "teacherId")
    private TeacherInfo teacherId;

    @NonNull
    private int sessionYear;

    @NonNull
    private String sessionSemester;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "course_Id", referencedColumnName = "courseId")
    private CourseTable course;

    @NotNull
    private String section;


}
