package com.example.University.Portal.services.AcademicSessionInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.AcademicCalender.AcadamicTimeTableDTO;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicTimeTable;
import com.example.University.Portal.Database_Connection.AcademicCalender.AcademicYearStatusenum;
import com.example.University.Portal.ExtraServices.BusinessIdGeneratorService;
import com.example.University.Portal.Repository.AcademicTimeTableRepository;

@Service
public class AcademicSessionCreationService {
    
    @Autowired
    AcademicTimeTableRepository academicTimeTableRepository;

    @Autowired
    BusinessIdGeneratorService idGen;

    public String addAcademicSession(AcadamicTimeTableDTO academicTimeTable) {

        AcademicTimeTable newSession = new AcademicTimeTable();
        newSession.setYear(academicTimeTable.getYear());
        newSession.setSemester(academicTimeTable.getSession());
        newSession.setStartDate(academicTimeTable.getStartDate());
        newSession.setEndDate(academicTimeTable.getEndDate());
        newSession.setSessionId(idGen.generateAcademicSessionId(academicTimeTable));
        newSession.setStatus(AcademicYearStatusenum.UPCOMING);

        academicTimeTableRepository.save(newSession);
        return "Academic session added successfully";
    }
}
