package com.example.blps_1.service;

import com.example.blps_1.dto.messages.NotificationMessage;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.dto.messages.NotificationMessage;
import com.example.blps_1.dto.messages.SubscribeStatusMessage;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

    private ClientService clientService;
    private ProductService productService;
    private final JavaMailSender javaMailSender;

    @Transactional
    @KafkaListener(topics = "subscribe-notifications", groupId = "myGroup", containerFactory = "kafkaListenerContainerFactory")
    public void setNotificationStatus(SubscribeStatusMessage subscribeStatusMessage) {
        Client client = clientService.readById(subscribeStatusMessage.getId());
        Product product = productService.readByName(subscribeStatusMessage.getProductDTO());
        if (client.getNotifications().contains(product)) {
            return;
        }
        client.getNotifications().add(product);
        clientService.update(client);
    }

    @Transactional
    @KafkaListener(topics = "unsubscribe-notifications", groupId = "myGroup", containerFactory = "kafkaListenerContainerFactory")
    public void deleteNotificationStatus(SubscribeStatusMessage subscribeStatusMessage){
        Client client = clientService.readById(subscribeStatusMessage.getId());
        Product product = productService.readByName(subscribeStatusMessage.getProductDTO());
        client.getNotifications().remove(product);
        clientService.update(client);
    }

    @KafkaListener(topics = "notifications", groupId = "myGroup", containerFactory = "kafkaListenerContainerFactory")
    public void sendNotification(NotificationMessage notificationMessage){
        Client client = clientService.readById(notificationMessage.getId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(client.getMail());
        message.setSubject(notificationMessage.getTopic());
        message.setText(notificationMessage.getBody());
        javaMailSender.send(message);
    }
}
