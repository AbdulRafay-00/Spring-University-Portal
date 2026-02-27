package com.example.University.Portal.Database_Connection;

import com.example.University.Portal.Database_Connection.CourseInfo.CourseTable;
import com.example.University.Portal.Database_Connection.Key.StudentCourseEmbaded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "student_enrollment")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentCourseEnrollment {
    
    @EmbeddedId
    private StudentCourseEmbaded id;

    @NonNull
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @Getter(AccessLevel.NONE)
    private StudentInfo studentInfo;

    @NonNull
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    @Getter(AccessLevel.NONE)
    private CourseTable courseTable;

    @NonNull
    private int year;
}
