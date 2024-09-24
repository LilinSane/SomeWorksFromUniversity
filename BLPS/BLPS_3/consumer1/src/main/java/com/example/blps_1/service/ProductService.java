package com.example.blps_1.service;

import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Product;
import com.example.blps_1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    @Transactional
    public Product readByName(ProductDTO productDTO) {
        return productRepository.findByName(productDTO.getName()).orElseThrow(() -> new NullPointerException("Товара с таким именем не существует"));
    }
}
