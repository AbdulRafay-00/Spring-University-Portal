package com.example.University.Portal.services.KafkaServices;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReqListner {
    
    @KafkaListener(topics = "ai-response-topic", groupId = "portal-group")
    public void receiveResponse(String response) {
    System.out.println("AI Response: " + response);
}
}
