package com.example.University.Portal.Crud_Operation.LimitedAccessOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Portal.Database_Connection.CourseInfo.CourseOfferingTable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/admin")
@RestController
public class AdminAccess {


    @PostMapping("/course/offering")
    public String CourseOffering(@RequestBody CourseOfferingTable entity) {
        //TODO: process POST request
        
        return "";
    }
    

    
}
