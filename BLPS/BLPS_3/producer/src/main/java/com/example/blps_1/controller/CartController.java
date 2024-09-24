package com.example.blps_1.controller;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Product;
import com.example.blps_1.service.CartService;
import com.example.blps_1.service.ClientService;
import com.example.blps_1.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final ProductService productService;
    private final ClientService clientService;
    private final CartService cartService;

    @GetMapping("/{clientId}/items")
    public ResponseEntity<List<Product>> get(@Valid @PathVariable Long clientId){
        if (clientService.readById(clientId) == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(clientService.readById(clientId).getCart(), HttpStatus.OK);
    }

    @PostMapping("/{clientId}/items")
    public ResponseEntity<Product> add(@Valid @PathVariable Long clientId, @RequestBody ProductDTO productDTO){
        if (clientService.readById(clientId) == null) {
            return ResponseEntity.notFound().build();
        }
        if(productService.readByName(productDTO) == null || productDTO.getAmount() > productService.readByName(productDTO).getAmount()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(cartService.add(clientId, productDTO), HttpStatus.OK);
    }

    @PutMapping("/{clientId}/items")
    public ResponseEntity<Product> update(@PathVariable Long clientId, @RequestBody ProductDTO productDTO) {
        if(!cartService.update(clientId, productDTO)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clientId}/items")
    public HttpStatus delete(@PathVariable Long clientId, @RequestBody ProductDTO productDTO) {
        if(!cartService.delete(clientId, productDTO)){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
