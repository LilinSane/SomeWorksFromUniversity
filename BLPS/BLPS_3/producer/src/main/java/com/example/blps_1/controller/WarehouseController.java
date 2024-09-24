package com.example.blps_1.controller;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.dto.messages.NotificationMessage;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import com.example.blps_1.service.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
@AllArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;
    private final ClientService clientService;
    private final KafkaSenderService senderService;

    @PostMapping
    public ResponseEntity<Product> add(@Valid @RequestBody ProductDTO productDTO){
        Product product = warehouseService.addAmount(productDTO);
        for (Client client : clientService.readAllByProductId(productDTO)){
            senderService.sendMessage(new NotificationMessage(client.getId(), "Notification", "Your product is available now"), "notifications");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Product> subtract(@Valid @RequestBody ProductDTO productDTO){
        Product product = warehouseService.subAmount(productDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
