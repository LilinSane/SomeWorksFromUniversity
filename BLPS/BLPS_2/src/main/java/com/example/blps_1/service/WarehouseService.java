package com.example.blps_1.service;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Product;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WarehouseService {

    private final ProductService productService;
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Product addAmount(ProductDTO productDTO) {
        Product product = productService.readByName(productDTO);
        product.setAmount(product.getAmount() + productDTO.getAmount());
        return productService.update(product);
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Product subAmount(ProductDTO productDTO) {
        Product product = productService.readByName(productDTO);
        product.setAmount(product.getAmount() - productDTO.getAmount());
        return productService.update(product);
    }
}
