package com.example.University.Portal.services.CourseServices;

import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.CourseInfo.DtoCourseOfferingRequest;
import com.example.University.Portal.ExtraServices.BusinessIdGeneratorService;
import com.example.University.Portal.Repository.CourseDetailRepository;
import com.example.University.Portal.Repository.CourseOfferingRepository;
import com.example.University.Portal.Repository.TeacherDetailRepository;


@Service
public class TechCourseOffering {

    private  BusinessIdGeneratorService businessIdGeneratorService;
    private TeacherDetailRepository teacherDetailRepository;
    private CourseOfferingRepository courseOfferingRepository;
    private CourseDetailRepository courseDetailRepository;
    
    public String teacherCourseAssign(DtoCourseOfferingRequest courseOfferingRequest) {

        if (courseDetailRepository.findByCourseId(courseOfferingRequest.getCourseId()).isPresent()) {
            
        }


        return "Course Offering Created Successfully";
    }
}
