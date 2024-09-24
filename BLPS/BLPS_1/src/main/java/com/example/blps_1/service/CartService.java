package com.example.blps_1.service;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private ClientService clientService;
    private ProductService productService;

    public Product add(Long clientId, ProductDTO productDTO){
        Client client = clientService.readById(clientId);
        Product product = productService.readByName(productDTO);
        for (int i = 0; i < productDTO.getAmount(); i++){
            client.getCart().add(product);
        }
        clientService.update(client);
        return product;
    }

    public boolean update(Long clientId, ProductDTO productDTO){
        Client client = clientService.readById(clientId);
        if (client == null
                || productService.readByName(productDTO) == null
                || !client.getCart().contains(productService.readByName(productDTO))) {
            return false;
        }
        int amount = productDTO.getAmount();
        if(amount > 0){
            for (int i = 0; i < amount; i++){
                client.getCart().add(productService.readByName(productDTO));
            }
        }
        else {
            for (int i = amount; i < 0; i++){
                client.getCart().remove(productService.readByName(productDTO));
            }
        }
        clientService.update(client);
        return true;
    }

    public boolean delete(Long clientId, ProductDTO productDTO){
        Client client = clientService.readById(clientId);
        if (client == null
                || productService.readByName(productDTO) == null
                || !client.getCart().contains(productService.readByName(productDTO))) {
            return false;
        }
        int amount = productDTO.getAmount();
        for (int i = 0; i < amount; i++){
            client.getCart().add(productService.readByName(productDTO));
        }
        clientService.update(client);
        return true;
    }
}
