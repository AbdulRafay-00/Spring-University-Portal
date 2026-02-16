package com.example.University.Portal.Database_Connection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "teacher_course_table")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TeacherCourse {
    
}
