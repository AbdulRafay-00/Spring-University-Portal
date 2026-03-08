package com.example.University.Portal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.Key.StudentCourseEmbaded;
import com.example.University.Portal.Database_Connection.StudentCourseEnroll.StudentCourseEnrollment;

import lombok.NonNull;

@Repository
public interface StudentCourseEnrollmentRepository extends JpaRepository<StudentCourseEnrollment, StudentCourseEmbaded> {


    @Query(value = """
    insert into StudentCourseEnrollment (student_id, course_id, course_offering_id, marks, grade, gpa)
    select s.studentId, c.courseId, o.courseOfferingId, "", 0.0, 0.0 from StudentInfo s
    join CourseTable c on s.currentSemester = c.semester
    join CourseOfferingTable o on c.courseId = o.courseId
    where o.year = :year and o.session = :session
            """)
    public List<StudentInfo> findDistinctStudentsBySession(int year, String session) ;
    
}
