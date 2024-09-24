package com.example.blps_1.delegators;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.service.CartService;
import com.example.blps_1.service.KafkaSenderService;
import com.example.blps_1.service.PaymentService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named("pay")
@AllArgsConstructor
public class Pay implements JavaDelegate {

    private PaymentService paymentService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String status = paymentService.handle((Long) delegateExecution.getVariable("client_id")) ? "Success" : "Failure";
        delegateExecution.setVariable("status", status);
    }
}