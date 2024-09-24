package com.example.blps_1.dto.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationMessage implements Message {

    private Long id;
    private String topic;
    private String body;
}
