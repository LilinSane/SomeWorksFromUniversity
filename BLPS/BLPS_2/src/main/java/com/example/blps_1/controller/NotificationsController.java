package com.example.blps_1.controller;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.service.NotificationService;
import com.example.blps_1.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
public class NotificationsController {

    private final NotificationService notificationService;
    private final ProductService productService;

    @PostMapping("/{clientId}/subscribe")
    public ResponseEntity<String> add(@Valid @PathVariable Long clientId, @RequestBody ProductDTO productDTO){
        if (productService.readByName(productDTO) == null){
            return ResponseEntity.notFound().build();
        }
        if(!notificationService.setNotificationStatus(clientId, productDTO)){
            return ResponseEntity.badRequest().body("Продукт уже добавлен в подписку");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}/unsubscribe")
    public ResponseEntity<String> delete(@Valid @PathVariable Long clientId, @RequestBody ProductDTO productDTO){
        if (productService.readByName(productDTO) == null){
            return ResponseEntity.notFound().build();
        }
        if(notificationService.deleteNotificationStatus(clientId, productDTO)){
            return ResponseEntity.badRequest().body("Вы не подписаны на данный продукт");
        }
        return ResponseEntity.ok().build();
    }
}
