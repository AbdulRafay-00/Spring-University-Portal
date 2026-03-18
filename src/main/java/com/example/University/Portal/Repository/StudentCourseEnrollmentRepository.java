package com.example.University.Portal.Repository;

import java.beans.Transient;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.KafkaResultObj.ResultAiResDto;
import com.example.University.Portal.Database_Connection.Key.StudentCourseEmbaded;
import com.example.University.Portal.Database_Connection.StudentCourseEnroll.StudentCourseEnrollment;

import jakarta.transaction.Transactional;
import lombok.NonNull;

@Repository
public interface StudentCourseEnrollmentRepository
        extends JpaRepository<StudentCourseEnrollment, StudentCourseEmbaded> {

    // @Transactional
    // @Modifying
    // @Query(value = """
    //         insert into StudentCourseEnrollment (student_id, course_id, course_offering_id, marks, grade, gpa)
    //         select s.studentId, c.courseId, o.courseOfferingId, "", 0.0, 0.0 from StudentInfo s
    //         join CourseTable c on s.currentSemester = c.semester
    //         join CourseOfferingTable o on c.courseId = o.courseId
    //         where o.year = :year and o.session = :session
    //                 """)
    // public List<StudentInfo> findDistinctStudentsBySession(int year, String session);

    // // gpt writen

    @Modifying
    @Transactional
    @Query(value = """
            INSERT INTO student_enrollment (gpa, marks, student_id, grade, course_offering_id)
            SELECT 0.0, null, s.student_id, '', o.course_offering_id
            FROM student_info s
            JOIN course_table c ON s.current_semester = c.semester
            JOIN course_offering_table o ON c.course_id = o.course_id
            WHERE o.session_year = :year AND o.session_semester = :session
            """, nativeQuery = true)
    public void insertEnrollmentsForSession(@Param("year") int sessionYear, @Param("session") String session);


           @Query(value = """
            SELECT c.course_name AS courseName, e.marks AS marks
            FROM student_enrollment e
            JOIN course_offering_table co
                ON e.course_offering_id = co.course_offering_id
            JOIN course_table c
                ON c.course_id = co.course_id
            WHERE e.student_id = :studentId
            """, nativeQuery = true)
    List<Object[]> getStudentMarks(String studentId);

}
