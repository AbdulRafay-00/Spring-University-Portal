package com.example.University.Portal.services.KafkaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendStudentMarks(String marksJson) {
        kafkaTemplate.send("student-marks-topic", marksJson);
    }
}