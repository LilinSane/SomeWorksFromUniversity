package com.example.blps_1.delegators;

import com.example.blps_1.entity.Client;
import com.example.blps_1.service.ClientService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named("authorization")
@AllArgsConstructor
public class Authorization implements JavaDelegate {

    private ClientService clientService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        String password = (String) delegateExecution.getVariable("password");
        Client client = clientService.readByMail(email);
        boolean is_Authorized = client.getPassword().equals(password);
        delegateExecution.setVariable("is_Authorized", is_Authorized);
        delegateExecution.setVariable("client_id", client.getId());
    }
}
