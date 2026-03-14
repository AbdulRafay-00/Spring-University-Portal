package com.example.University.Portal.services.Scheduler;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicYearStatusenum;
import com.example.University.Portal.Database_Connection.StudentCourseEnroll.StudentCourseEnrollment;
import com.example.University.Portal.Repository.AcademicTimeTableRepository;
import com.example.University.Portal.services.AcademicSessionInfo.StudentPromotionService;
import com.example.University.Portal.services.StudentCourseEnrollmentService.StudentCourseEnrollmentService;

import jakarta.transaction.Transactional;


@Service
public class SessionSchedularService {

    @Autowired
    AcademicTimeTableRepository academicSessionRepository;
    @Autowired
    StudentPromotionService studentPromotionService;
    @Autowired
    StudentCourseEnrollmentService enrollmentService;

@Scheduled(cron = "0 0 0 * * ?")
@Transactional
public void checkSessionEnd() {
    LocalDate today = LocalDate.now();
    System.out.println("Scheduler running: " + today);
    List<AcademicTimeTable> sessions =
        academicSessionRepository
        .findByEndDateBeforeOrEqualAndStatus(
            today,
            AcademicYearStatusenum.ACTIVE
        );
        String sessionHolder ="";

    for (AcademicTimeTable session : sessions) {
        session.setStatus(AcademicYearStatusenum.COMPLETED);
        sessionHolder = session.getSemester();

        academicSessionRepository.save(session);
    }

    System.out.println("Sessions found: " + sessions.size());

StudentInfo student = new StudentInfo();
    studentPromotionService.autoPromoteStudents();
    // studentPromotionService.promoteStudentsession( student);


    System.out.println("Students promoted for session: " + sessionHolder);
    System.out.println(today.getYear());

    enrollmentService.asignCoursesToPromotedStudents(today.getYear(), sessionHolder);
}
}
