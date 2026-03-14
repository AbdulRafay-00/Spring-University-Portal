import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.CourseInfo.DtoCourseCreation;
import com.example.University.Portal.Repository.CourseDetailRepository;

package com.example.University.Portal.services.CourseServices;


@Service
public class CourseCreationService {
    
    @Autowired
    CourseDetailRepository courseDetailRepository;


    public void createCourse(DtoCourseCreation courseCreation) {

        courseDetailRepository.findByCourseId(courseCreation.getCourseId())
            .ifPresentOrElse(existingCourse -> {
                throw new UserAlreadyExist("Course already exists with ID: " + courseCreation.getCourseId());
            }, () -> {
                CourseTable newCourse = new CourseTable();
                newCourse.setCourseName(courseCreation.getCourseName());
                newCourse.setCourseId(courseCreation.getCourseId());
                newCourse.setDepartment(courseCreation.getDepartment());
                newCourse.setCreditHour(courseCreation.getCreditHour());
                
                courseDetailRepository.save(newCourse);
            });
    }
}