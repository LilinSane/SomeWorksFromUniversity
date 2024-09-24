package com.example.blps_1.service;

import bitronix.tm.BitronixTransactionManager;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PaymentService {

    private ClientService clientService;
    @Transactional(isolation = Isolation.REPEATABLE_READ)
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
