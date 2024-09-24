package com.example.blps_1.service;

import com.example.blps_1.entity.Client;
import com.example.blps_1.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;


    public Client readById(Long id){
        return clientRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void update(Client client){
        clientRepository.save(client);
    }

}
