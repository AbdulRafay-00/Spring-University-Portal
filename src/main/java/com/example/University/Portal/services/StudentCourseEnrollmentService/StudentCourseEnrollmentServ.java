package com.example.University.Portal.services.StudentCourseEnrollmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Repository.StudentCourseEnrollmentRepository;

// automatic called when the session is marked as completed in the AcademicTimeTableService
// it will promote students to the next semester and also enroll them in the courses of the next
@Service
public class StudentCourseEnrollmentServ {

    @Autowired
    StudentCourseEnrollmentRepository enrollmentRepository;

    public void asignCoursesToPromotedStudents(int year, String session) {
        String setSession = "";

        if ("FALL".equals(session)) {
            setSession = "SPRING";
        } else if ("SPRING".equals(session)) {
            setSession = "FALL";
        }

        // enrollmentRepository.findDistinctStudentsBySession(year, setSession);
        enrollmentRepository.insertEnrollmentsForSession(2026, setSession);
    }

    // mujha courseid chaia us ka semester chaia sahi ha
    // mujha next session id charia (get.sessionid + 1)
    // query likho
    // insert into StudentCourseEnrollment (student_id, course_id,
    // course_offering_id, grade, marks. gpa)
    // select s.studentId, c.courseId, o.courseOfferingId, "", 0.0, 0.0 from
    // StudentInfo s
    // join CourseTable c on s.currentSemester = c.semester
    // join CourseOfferingTable o on c.courseId = o.courseId
    // where o.year = :year and o.session = :session

}
