package com.example.blps_1.service;

import com.example.blps_1.dto.ClientDTO;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.entity.Product;
import com.example.blps_1.entity.Role;
import com.example.blps_1.repository.ClientRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;
    private ProductService productService;


    public Client create(Client client){
       return clientRepository.save(client);
    }

    public Client readById(Long id){
        return clientRepository.findById(id).orElseThrow();
    }

    public Client readByMail(String mail){
        return clientRepository.findClientByMail(mail).orElseThrow();
    }
    @Transactional
    public void update(Client client){
        clientRepository.save(client);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
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

    public UserDetailsService userDetailsService() {
        return this::readByMail;
    }

    public Client getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var mail = SecurityContextHolder.getContext().getAuthentication().getName();
        return readByMail(mail);
    }
}
