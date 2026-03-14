package com.example.University.Portal.services.AcademicSessionInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.StudentCourseEnroll.StudentCourseEnrollment;
import com.example.University.Portal.Repository.CourseDetailRepository;
import com.example.University.Portal.Repository.CourseOfferingRepository;
import com.example.University.Portal.Repository.StuDetailRepository;
import com.example.University.Portal.Repository.StudentCourseEnrollmentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentPromotionService {
    
    @Autowired
    StuDetailRepository stuDetailRepository;

// manual Approatch to update student semester and year


    // private StudentCourseEnrollmentRepository enrollmentRepository;
    // private StuDetailRepository studentRepository;
    // private CourseOfferingRepository courseOfferingRepository;
    // private CourseDetailRepository curriculumRepository;

// public void promoteStudentsession(StudentInfo student) {
//     int semester = student.getCurrentSemester();
//     int year = student.getCurrentYear();

//     // assume 2 semesters per year
//     if (semester % 2 == 0) {
//         student.setCurrentSemester(semester + 1);
//         student.setCurrentYear(year + 1);
//     } else {
//         student.setCurrentSemester(semester + 1);
//     }

//     stuDetailRepository.save(student);
// }





public void autoPromoteStudents() {

    stuDetailRepository.promoteAllStudents();


}

    // @Transactional
    // public void promoteStudents(AcademicTimeTable completedSession) {

    //     // 1️⃣ Get all students who were enrolled in this session
    //     List<StudentInfo> students = enrollmentRepository.findDistinctStudentsBySession(
    //         completedSession.getSessionId()
    //     );

    //     // 2️⃣ Increment semester/year for each student
    //     for (StudentInfo student : students) {
    //         incrementSemester(student);
    //         studentRepository.save(student);
    //     }
    // }

    // /**
    //  * Helper method to increment student semester and year
    //  */
    // private void incrementSemester(StudentInfo student) {
    //     int semester = student.getCurrentSemester();
    //     int year = student.getCurrentYear();

    //     // Assuming 2 semesters per year
    //     if (semester == 2) {
    //         student.setCurrentSemester(1);
    //         student.setCurrentYear(year + 1);
    //     } else {
    //         student.setCurrentSemester(semester + 1);
    //     }
    // }


}