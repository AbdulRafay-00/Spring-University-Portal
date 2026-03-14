package com.example.University.Portal.Crud_Operation.LimitedAccessOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Portal.Database_Connection.CourseInfo.DtoCourseCreation;
import com.example.University.Portal.Database_Connection.CourseInfo.DtoCourseOfferingRequest;
import com.example.University.Portal.services.CourseServices.CourseCreationService;
import com.example.University.Portal.services.CourseServices.TechCourseOffering;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/admin")
@RestController
public class AdminAccess {

    @Autowired
    private TechCourseOffering techCourseOffering;
    private CourseCreationService courseCreationService;
//course creation
    @PostMapping("/course/create")
    public String CourseCreation(@Valid @RequestBody DtoCourseCreation courseCreation) {

        return courseCreationService.createCourse(courseCreation);
    }




    // course offering
    @PostMapping("/course/offering")
    public String CourseOffering(@Valid  @RequestBody DtoCourseOfferingRequest courseOfferingRequest) {
        // TODO: process POST request

        return techCourseOffering.teacherCourseAssign(courseOfferingRequest);
    }


}
