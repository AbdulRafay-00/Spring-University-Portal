package com.example.University.Portal.Crud_Operation.AiMicroserviceOperation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.University.Portal.Database_Connection.KafkaResultObj.ResultAiResDto;
import com.example.University.Portal.Database_Connection.Key.StudentCourseEmbaded;
import com.example.University.Portal.Repository.StuDetailRepository;
import com.example.University.Portal.Repository.StudentCourseEnrollmentRepository;
import com.example.University.Portal.services.JwtServices.JwtServices;
import com.example.University.Portal.services.KafkaServices.KafkaProducerService;


@RestController()
@RequestMapping("/ai")
public class ExtractStuid {

        private final JwtServices jwtServices;
        private final StuDetailRepository stuDetailRepository;
        StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;
        KafkaProducerService kafkaProducerService;


    public ExtractStuid(JwtServices jwtServices,
        StuDetailRepository stuDetailRepository,
        StudentCourseEnrollmentRepository studentCourseEnrollmentRepository,
        KafkaProducerService kafkaProducerService) {
        this.jwtServices = jwtServices;
        this.stuDetailRepository = stuDetailRepository;
        this.studentCourseEnrollmentRepository = studentCourseEnrollmentRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

@GetMapping("/ai-analysis")
public String getAiAnalysis(@RequestHeader("Authorization") String authHeader) {

    // The JWT token comes as: "Bearer <token>"
    String token = authHeader.replace("Bearer ", "");

    // Extract email using your JwtServices
    String email = jwtServices.extractUserName(token);

    // Now you have the email of the logged-in student
    System.out.println("Logged-in student email: " + email);

    // Example: fetch studentId from email
    String studentId = stuDetailRepository.findByStuEmail(email).get().getStudentId();

    // Get marks for AI
    List<Object[]> rawList = studentCourseEnrollmentRepository.getStudentMarks(studentId);


List<ResultAiResDto> studentMarks1 = rawList.stream()
    .map(r -> new ResultAiResDto(
        (String) r[0],                  // courseName
        ((Number) r[1]).intValue()      // marks
    ))
    .collect(Collectors.toList());

kafkaProducerService.sendStudentMarks(studentMarks1);

    return "request sent to AI microservice for analysis";
}
}
