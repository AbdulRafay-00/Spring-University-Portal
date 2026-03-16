package com.example.University.Portal.ExtraServices;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.AcademicCalender.AcadamicTimeTableDTO;
import com.example.University.Portal.Database_Connection.CourseInfo.CourseOfferingTable;
import com.example.University.Portal.Repository.AdminDetailRepository;
import com.example.University.Portal.Repository.StuDetailRepository;
import com.example.University.Portal.Repository.TeacherDetailRepository;

@Service
public class BusinessIdGeneratorService {

    @Autowired
    private TeacherDetailRepository teacherRepo;

    @Autowired
    private StuDetailRepository studentRepo;

    @Autowired
    private AdminDetailRepository adminRepo;


    public String generateTeacherCode() {
        int year = LocalDate.now().getYear();

        long count = teacherRepo.countByJoiningYear(year);

        return year + "/T" + String.format("%03d", count + 1);
    }

    public String generateStudentCode() {
        int year = LocalDate.now().getYear();

        long count = studentRepo.countByJoiningYear(year);

        return year + "/S" + String.format("%03d", count + 1);
    }

    public String generateAdminCode() {
        int year = LocalDate.now().getYear();

        long count = adminRepo.countByJoiningYear(year);

        return year + "/A" + String.format("%03d", count + 1);
    }


    public String generateCourseOfferingCode(CourseOfferingTable courseOffering) {

        return courseOffering.getCourse().getCourseId() +"_"
        + courseOffering.getSessionYear()+courseOffering.getSessionSemester()
        + "_" + courseOffering.getSection();
    }

    public String generateAcademicSessionId(AcadamicTimeTableDTO academicTimeTable) {
        return academicTimeTable.getYear() + "_" + academicTimeTable.getSession();
    }


}
