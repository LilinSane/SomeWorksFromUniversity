package com.example.blps_1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("subscribe-notifications").build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("unsubscribe-notifications").partitions(3).build();
    }

    @Bean
    public NewTopic topic3() {
        return TopicBuilder.name("notifications").partitions(3).build();
    }
}
