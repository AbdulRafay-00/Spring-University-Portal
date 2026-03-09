package com.example.University.Portal.services.CourseServices;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.TeacherInfo;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.CourseInfo.CourseOfferingTable;
import com.example.University.Portal.Database_Connection.CourseInfo.CourseTable;
import com.example.University.Portal.Database_Connection.CourseInfo.DtoCourseOfferingRequest;
import com.example.University.Portal.Exceptions.ExceptionType.UserAlreadyExist;
import com.example.University.Portal.Exceptions.ExceptionType.UserNotFound;
import com.example.University.Portal.ExtraServices.BusinessIdGeneratorService;
import com.example.University.Portal.Repository.AcademicTimeTableRepository;
import com.example.University.Portal.Repository.CourseDetailRepository;
import com.example.University.Portal.Repository.CourseOfferingRepository;
import com.example.University.Portal.Repository.TeacherDetailRepository;


@Service
public class TechCourseOffering {

    @Autowired
    private  BusinessIdGeneratorService businessIdGeneratorService;
    @Autowired
    private TeacherDetailRepository teacherDetailRepository;
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;
    @Autowired
    private CourseDetailRepository courseDetailRepository;
    @Autowired
    private AcademicTimeTableRepository academicTimeTableRepository;
    
    public String teacherCourseAssign(DtoCourseOfferingRequest courseOfferingRequest) {
        
        CourseTable course = courseDetailRepository.findByCourseId(courseOfferingRequest.getCourseId())
        .orElseThrow(() -> new UserNotFound("Course not found with ID: " + courseOfferingRequest.getCourseId()));
        
        
        TeacherInfo teacher = teacherDetailRepository.findByTeacherId(courseOfferingRequest.getTeacherId())
        .orElseThrow(() -> new UserNotFound("Teacher not found with ID: " + courseOfferingRequest.getTeacherId()));

        AcademicTimeTable academicSession = academicTimeTableRepository.findBySessionId(courseOfferingRequest.getAcademicSessionId())
        .orElseThrow(() -> new UserNotFound("Academic session not found with ID: " + courseOfferingRequest.getAcademicSessionId()));
        
        
        if (courseDetailRepository.findByCourseId(courseOfferingRequest.getCourseId()).isPresent()  &&
        teacherDetailRepository.findByTeacherId(courseOfferingRequest.getTeacherId()).isPresent()) {
            
            CourseOfferingTable courseOffering = new CourseOfferingTable();
            
            courseOffering.setCourse(course);
            courseOffering.setTeacherId(teacher);
            courseOffering.setSessionYear(LocalDate.now().getYear());
            courseOffering.setSessionSemester(courseOfferingRequest.getSessionSemester());
            courseOffering.setSection(courseOfferingRequest.getSection());
            courseOffering.setCourseOfferingId(businessIdGeneratorService.generateCourseOfferingCode(courseOffering));
            courseOffering.setAcademicTimeTable(academicSession);
            
            courseOfferingRepository.findByCourseOfferingId(courseOffering.getCourseOfferingId())
            .ifPresent(existing -> {
                throw new UserAlreadyExist("Course Offering already created with ID: " + existing.getCourseOfferingId());
            });

                courseOfferingRepository.save(courseOffering);
        }


        return "Course Offering Created Successfully";
    }
}
