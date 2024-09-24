package com.example.blps_1.service;

import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private ClientService clientService;

    public boolean handle(Long clientId){
        Client client = clientService.readById(clientId);
        if(client.getCart().isEmpty()){return false;}
        for(Product product: client.getCart()){
            if(product.getAmount() == 0){return false;}
            product.setAmount(product.getAmount() - 1);
        }
        client.getCart().clear();
        clientService.update(client);
        return true;
    }
}
