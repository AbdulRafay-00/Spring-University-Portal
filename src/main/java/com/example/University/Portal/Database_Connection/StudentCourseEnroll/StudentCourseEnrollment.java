package com.example.University.Portal.Database_Connection.StudentCourseEnroll;


import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.CourseInfo.CourseOfferingTable;
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
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "student_id")
    private StudentInfo studentInfo;

    @NonNull
    @ManyToOne
    @MapsId("courseOfferingId")
    @Getter(AccessLevel.NONE)
    @JoinColumn(name = "course_offering_id")
    private CourseOfferingTable courseTable;
    

    private double marks;
    
    @NonNull
    private String grade;
    
    
    @NonNull
    private double gpa;

}
