package com.example.University.Portal.Database_Connection.Key;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class StudentCourseEmbaded implements Serializable {
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_offering_id")
    private String courseOfferingId;
}
