package com.example.University.Portal.services.StudentDataQueryService;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.University.Portal.DB_Recorces.StudentStructure;
import com.example.University.Portal.DTOS.GetStudentDto;
import com.example.University.Portal.Database_Connection.StudentInfo;
import com.example.University.Portal.Repository.StuDetailRepository;
@Service
public class StudentDataOperation {

    private final StuDetailRepository stuDetailRepository;

    StudentDataOperation(StuDetailRepository stuDetailRepository){
        this.stuDetailRepository = stuDetailRepository;
    }

    public List<GetStudentDto> displayAllData() {

        List<StudentInfo> students = stuDetailRepository.findAll();

        return students.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private GetStudentDto mapToDTO(StudentInfo s) {

        GetStudentDto dto = new GetStudentDto();

        dto.setStudentId(s.getStudentId());
        dto.setStuName(s.getStuName());
        dto.setAge(s.getAge());
        dto.setStuPhone(s.getStuPhone());
        dto.setSection(s.getSection());
        dto.setCurrentYear(s.getCurrentYear());
        dto.setCurrentSemester(s.getCurrentSemester());

        if (s.getLoginInfo() != null) {
            dto.setEmail(s.getLoginInfo().getEmail());
        }

        return dto;
    }
}