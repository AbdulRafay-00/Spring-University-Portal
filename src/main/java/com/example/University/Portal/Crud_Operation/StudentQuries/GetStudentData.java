package com.example.University.Portal.Crud_Operation.StudentQuries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Portal.DB_Recorces.StudentStructure;
import com.example.University.Portal.DTOS.GetStudentDto;
import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.services.StudentDataQueryService.StudentDataOperation;

@RestController
public class GetStudentData {
    @Autowired
    StudentDataOperation studentDataOperation;
    @GetMapping("/getStudentData")
    public List<GetStudentDto> getStudentData() {
        return studentDataOperation.displayAllData();
    }

}
