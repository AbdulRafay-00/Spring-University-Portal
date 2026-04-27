package com.example.University.Portal.DTOS;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetStudentDto {
    private String email;
    private String studentId;   // ADD THIS

    private String stuName;
    private int age;
    private String stuPhone;
    private String section;

    private int currentYear;     // ADD THIS
    private int currentSemester; // ADD THIS

}
