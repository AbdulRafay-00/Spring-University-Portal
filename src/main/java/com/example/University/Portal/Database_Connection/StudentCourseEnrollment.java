package com.example.University.Portal.Database_Connection;

import com.example.University.Portal.Database_Connection.Key.StudentCourseEmbaded;

import jakarta.annotation.Nullable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_enrollment")
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentCourseEnrollment {
    
    @EmbeddedId
    private StudentCourseEmbaded id;

    @NonNull
    @OneToMany
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @Getter(AccessLevel.NONE)
    private String studentId;

    @NonNull
    @OneToMany
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    @Getter(AccessLevel.NONE)
    private String courseId;

    @NonNull
    @Getter(value = AccessLevel.NONE)
    private int year;
}
