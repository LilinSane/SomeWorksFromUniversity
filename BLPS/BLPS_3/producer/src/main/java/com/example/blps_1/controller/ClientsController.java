package com.example.blps_1.controller;

import com.example.blps_1.dto.ClientDTO;
import com.example.blps_1.entity.Client;
import com.example.blps_1.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientsController {

    private final ClientService clientService;

//    @PostMapping
//    public ResponseEntity<Client> create(@RequestBody ClientDTO clientDTO) {
//        return new ResponseEntity<>(clientService.create(clientDTO), HttpStatus.OK);
//    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> get(@Valid @PathVariable Long clientId) {
        return new ResponseEntity<>(clientService.readById(clientId), HttpStatus.OK);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.updateClientData(clientId, clientDTO), HttpStatus.OK);
    }

    @DeleteMapping("{clientId}")
    public HttpStatus delete(@Valid @PathVariable Long clientId) {
        if(!clientService.delete(clientId)){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

}
