package com.example.University.Portal.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.CourseInfo.CourseTable;
import com.example.University.Portal.Database_Connection.CourseInfo.DtoCourseCreation;
import com.example.University.Portal.Exceptions.ExceptionType.UserAlreadyExist;
import com.example.University.Portal.Repository.CourseDetailRepository;



@Service
public class CourseCreationService {
    
    @Autowired
    CourseDetailRepository courseDetailRepository;


    public String  createCourse(DtoCourseCreation courseCreation) {

        courseDetailRepository.findByCourseId(courseCreation.getCourseId())
            .ifPresentOrElse(existingCourse -> {
                throw new UserAlreadyExist("Course already exists with ID: " + courseCreation.getCourseId());
            }, () -> {
                CourseTable newCourse = new CourseTable();
                newCourse.setCourseName(courseCreation.getCourseName());
                newCourse.setCourseId(courseCreation.getCourseId());
                newCourse.setDepartment(courseCreation.getDepartment());
                newCourse.setCreditHour(courseCreation.getCreditHour());
                newCourse.setSemester(courseCreation.getSemester());
                courseDetailRepository.save(newCourse);
            });
        return "Course created successfully";
    }
}