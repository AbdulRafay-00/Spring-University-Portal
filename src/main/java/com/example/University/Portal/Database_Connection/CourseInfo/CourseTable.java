package com.example.University.Portal.Database_Connection.CourseInfo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "course_table")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CourseTable {

    @Id
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private long id;

    @NonNull
    private String courseId;

    @NonNull
    private String courseName;

    @NonNull
    private String creditHour;

    @NonNull
    private String department;

    // in mapped by give the name of the variable in courseoffering table that is referencing teacher info  like private TeacherInfo teacherId; in course offering table
    // @OneToMany(mappedBy = "courseId")
    // private List<CourseOfferingTable> courseOfferings;
}
