package com.example.University.Portal.services.KafkaServices;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReqListner {
    
    @KafkaListener(topics = "ai-response-topic", groupId = "portal-group")
    public void receiveResponse(String response) {
    System.out.println("AI Response: " + response);
}
}
