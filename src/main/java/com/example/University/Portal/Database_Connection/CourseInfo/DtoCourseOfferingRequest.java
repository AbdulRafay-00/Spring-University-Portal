package com.example.University.Portal.Database_Connection.CourseInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoCourseOfferingRequest {
    private  String courseId;
    private String sessionSemester;
    private String teacherId;
}
