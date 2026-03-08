package com.example.University.Portal.services.Scheduler;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicYearStatusenum;
import com.example.University.Portal.Database_Connection.StudentCourseEnroll.StudentCourseEnrollment;
import com.example.University.Portal.Repository.AcademicTimeTableRepository;
import com.example.University.Portal.services.AcademicSessionInfo.StudentPromotionService;
import com.example.University.Portal.services.StudentCourseEnrollmentService.StudentCourseEnrollmentService;

public class SessionSchedularService {

    @Autowired
    AcademicTimeTableRepository academicSessionRepository;
    @Autowired
    StudentPromotionService studentPromotionService;
    @Autowired
    StudentCourseEnrollmentService enrollmentService;

    @Scheduled(cron = "0 0 0 * * ?")
public void checkSessionEnd() {

    LocalDate today = LocalDate.now();
    List<AcademicTimeTable> sessions =
        academicSessionRepository
        .findByEndDateBeforeAndStatus(
            today,
            AcademicYearStatusenum.ACTIVE
        );
        String sessionHolder ="";

    for (AcademicTimeTable session : sessions) {

        session.setStatus(AcademicYearStatusenum.COMPLETED);
        sessionHolder = session.getSemester();

        academicSessionRepository.save(session);
    }

    studentPromotionService.autoPromoteStudents();
    enrollmentService.asignCoursesToPromotedStudents(today.getYear(), sessionHolder);
}
}
