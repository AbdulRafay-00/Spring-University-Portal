package com.example.University.Portal.Database_Connection.Key;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TeacherCourseEmbadedId implements Serializable {
    @Column(name = "teacher_Id")
    private String teacherId;
    @Column(name = "course_Id")
    private String courseId;
}
