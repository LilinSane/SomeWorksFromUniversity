package com.example.blps_1.controller;

import com.example.blps_1.service.NotificationService;
import com.example.blps_1.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentsController {

    private final PaymentService paymentService;
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> add(@Valid @RequestParam Long clientId) {
        String status = paymentService.handle(clientId) ? "Success" : "Failure";
        notificationService.sendNotification(clientId, "Payment", status);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
