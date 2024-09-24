package com.example.blps_1.delegators;

import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Role;
import com.example.blps_1.service.ClientService;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.ArrayList;

@Named("registration")
@AllArgsConstructor
public class Registration implements JavaDelegate {

    private ClientService clientService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        String password = (String) delegateExecution.getVariable("password");
        String name = (String) delegateExecution.getVariable("name");
        Client client = new Client();
        client.setMail(email);
        client.setPassword(password);
        client.setName(name);
        client.setRole(Role.ROLE_USER);
        client.setNotifications(new ArrayList<>());
        client.setCart(new ArrayList<>());
        clientService.create(client);
    }
}
