package com.example.blps_1.controller;

import com.example.blps_1.dto.messages.SubscribeStatusMessage;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.service.KafkaSenderService;
import com.example.blps_1.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
@Slf4j
public class NotificationsController {

    private final ProductService productService;
    private final KafkaSenderService senderService;

    @PostMapping("/{clientId}/subscribe")
    @Transactional
    public ResponseEntity<String> add(@Valid @PathVariable Long clientId, @RequestBody ProductDTO productDTO){
        if (productService.readByName(productDTO) == null){
            return ResponseEntity.notFound().build();
        }
        SubscribeStatusMessage subscribeStatusMessage = new SubscribeStatusMessage(clientId, productDTO);
        senderService.sendMessage(subscribeStatusMessage, "subscribe-notifications");
        log.info("Sending Json Serializer : {}", subscribeStatusMessage);
        log.info("--------------------------------");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}/unsubscribe")
    @Transactional
    public ResponseEntity<String> delete(@Valid @PathVariable Long clientId, @RequestBody ProductDTO productDTO){
        if (productService.readByName(productDTO) == null){
            return ResponseEntity.notFound().build();
        }
        senderService.sendMessage(new SubscribeStatusMessage(clientId, productDTO), "unsubscribe-notifications");
        return ResponseEntity.ok().build();
    }
}
