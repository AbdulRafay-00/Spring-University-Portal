package com.example.University.Portal.services.StudentDataQueryService;

import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Repository.StuDetailRepository;

@Service
public class StudentDataOperation {
    
    private StuDetailRepository stuDetailRepository;
    StudentDataOperation(StuDetailRepository stuDetailRepository){
        this.stuDetailRepository = stuDetailRepository;
    }

    public Iterable<StudentInfo> DisplayAllData() {
        return stuDetailRepository.findAll();
    }
    
}
