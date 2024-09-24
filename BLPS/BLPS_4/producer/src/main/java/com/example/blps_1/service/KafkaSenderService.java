package com.example.blps_1.service;

import com.example.blps_1.dto.messages.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaSenderService {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
