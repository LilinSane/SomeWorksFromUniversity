package com.example.blps_1.service;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private ClientService clientService;
    private ProductService productService;
    @Transactional
    public Product add(Long clientId, ProductDTO productDTO) {
        Client client = clientService.readById(clientId);
        Optional<Product> productOptional = client.getCart().stream()
                .filter(exProduct -> exProduct.getName().equals(productDTO.getName()))
                .findFirst();
        Product product;
        if(productOptional.isPresent()){
            product = productOptional.get();
            product.setAmount(product.getAmount() + productDTO.getAmount());
        }
        else {
            product = productService.readByName(productDTO);
            client.getCart().add(product);
        }
        clientService.update(client);
        return product;
    }
    @Transactional
    public boolean update(Long clientId, ProductDTO productDTO) {
        Client client = clientService.readById(clientId);
        Optional<Product> productOptional = client.getCart().stream()
                .filter(exProduct -> exProduct.getName().equals(productDTO.getName()))
                .findFirst();
        Product product;
        if (productOptional.isEmpty()) {
            return false;
        }
        product = productOptional.get();
        product.setAmount(product.getAmount() + productDTO.getAmount());
        if (product.getAmount() == 0){
            client.getCart().remove(product);
        }
        clientService.update(client);
        return true;
    }
    @Transactional
    public boolean delete(Long clientId, ProductDTO productDTO) {
        Client client = clientService.readById(clientId);
        Optional<Product> productOptional = client.getCart().stream()
                .filter(exProduct -> exProduct.getName().equals(productDTO.getName()))
                .findFirst();
        Product product;
        if (productOptional.isEmpty()) {
            return false;
        }
        product = productOptional.get();
        client.getCart().remove(product);
        clientService.update(client);
        return true;
    }
}
