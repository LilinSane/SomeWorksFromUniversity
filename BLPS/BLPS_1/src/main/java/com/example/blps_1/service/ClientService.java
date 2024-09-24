package com.example.blps_1.service;

import com.example.blps_1.dto.ClientDTO;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import com.example.blps_1.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private ProductService productService;

    public Client create(ClientDTO clientDTO){
       return clientRepository.save(Client.builder()
                .name(clientDTO.getName())
                .mail(clientDTO.getMail())
                .password(clientDTO.getPassword())
                .build());
    }

    public Client readById(Long id){
        return clientRepository.findById(id).orElseThrow();
    }

    public void update(Client client){
        clientRepository.save(client);
    }

    public Client updateClientData(Long clientId, ClientDTO clientDTO){
        Client client = readById(clientId);
        client.setMail(clientDTO.getMail());
        client.setName(clientDTO.getName());
        client.setPassword(clientDTO.getPassword());
        update(client);
        return client;
    }

    public boolean delete (Long id) {
        if(readById(id) == null){
            return false;
        }
        clientRepository.delete(readById(id));
        return true;
    }

    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    public List<Client> readAllByProductId(ProductDTO productDTO){
        Product product = productService.readByName(productDTO);
        return clientRepository.findByCartId(product.getId()).orElseThrow(() -> new NullPointerException("Такого айди не существует"));
    }

}
