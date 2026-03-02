package com.example.University.Portal.Database_Connection.CourseInfo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoCourseOfferingRequest {
    @NotBlank(message = "Course id is required")
    private  String courseId;
    @NotBlank(message = "Semester is required")
    private String sessionSemester;
    @NotBlank(message = "teacher id is required")
    private String teacherId;
    @NotBlank(message = "Section is required")
    private String section;
}
