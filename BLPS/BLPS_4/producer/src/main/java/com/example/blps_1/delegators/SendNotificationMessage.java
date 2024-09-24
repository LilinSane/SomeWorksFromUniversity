package com.example.blps_1.delegators;

import com.example.blps_1.dto.messages.NotificationMessage;
import com.example.blps_1.service.KafkaSenderService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named("sendNotificationMessage")
@AllArgsConstructor
public class SendNotificationMessage implements JavaDelegate {

    private KafkaSenderService kafkaSenderService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        kafkaSenderService.sendMessage(new NotificationMessage((Long) delegateExecution.getVariable("client_id"), "Payment", (String) delegateExecution.getVariable("status")), "notifications");
    }
}
