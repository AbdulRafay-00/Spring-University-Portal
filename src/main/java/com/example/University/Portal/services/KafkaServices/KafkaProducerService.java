package com.example.University.Portal.services.KafkaServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.University.Portal.Database_Connection.KafkaResultObj.ResultAiResDto;

import tools.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {

    @Autowired
private ObjectMapper objectMapper;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendStudentMarks(List<ResultAiResDto> studentMarks) {
        System.out.println("Sending student marks to Kafka: " + studentMarks   + "\n"  + "\n" + "-----------------------------"
        );
    try {
        String json = objectMapper.writeValueAsString(studentMarks);
        kafkaTemplate.send("student-marks-topic", json);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}