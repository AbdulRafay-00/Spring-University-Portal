package com.example.University.Portal.ExtraServices;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Repository.StuDetailRepository;
import com.example.University.Portal.Repository.TeacherDetailRepository;

@Service
public class BusinessIdGeneratorService {

    @Autowired
    private TeacherDetailRepository teacherRepo;

    @Autowired
    private StuDetailRepository studentRepo;

    public String generateTeacherCode() {
        int year = LocalDate.now().getYear();

        long count = teacherRepo.CountByJoiningYear(year);

        return year + "/T" + String.format("%03d", count + 1);
    }

    public String generateStudentCode() {
        int year = LocalDate.now().getYear();

        long count = studentRepo.CountByJoiningYear(year);

        return year + "/S" + String.format("%03d", count + 1);
    }
}
