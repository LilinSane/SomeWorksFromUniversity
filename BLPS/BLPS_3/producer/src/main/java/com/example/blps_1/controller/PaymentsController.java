package com.example.blps_1.controller;

import com.example.blps_1.dto.messages.NotificationMessage;
import com.example.blps_1.service.KafkaSenderService;
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
    private final KafkaSenderService senderService;

    @PostMapping
    public ResponseEntity<String> add(@Valid @RequestParam Long clientId) {
        String status = paymentService.handle(clientId) ? "Success" : "Failure";
        senderService.sendMessage(new NotificationMessage(clientId, "Payment", status), "notifications");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
