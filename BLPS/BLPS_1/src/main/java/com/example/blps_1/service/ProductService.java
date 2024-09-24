package com.example.blps_1.service;

import com.example.blps_1.dto.CategoryDTO;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Category;
import com.example.blps_1.entity.Product;
import com.example.blps_1.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final VendorService vendorService;

    public Product create(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .amount(productDTO.getAmount())
                .category(categoryService.readById(productDTO.getCategoryId()))
                .vendor(vendorService.readById(productDTO.getVendorId()))
                .build();
        return productRepository.save(product);
    }

    public Product readByName(ProductDTO productDTO) {
        return productRepository.findByName(productDTO.getName()).orElseThrow(() -> new NullPointerException("Товара с таким именем не существует"));
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(ProductDTO productDTO) {
        Product product = readByName(productDTO);
        if(product == null){
            return false;
        }
        productRepository.delete(product);
        return true;
    }

    public Page<Product> readAll(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    public List<Product> readAllByCategory(CategoryDTO categoryDTO) {
        Category category = categoryService.readByName(categoryDTO);
        return productRepository.findProductByCategory(category);
    }

    public Product updateProductData(Long id, ProductDTO productDTO){
        Product product = readById(id);
        product.setName(productDTO.getName());
        product.setAmount(productDTO.getAmount() + product.getAmount());
        product.setCategory(categoryService.readById(productDTO.getCategoryId()));
        product.setVendor(vendorService.readById(productDTO.getVendorId()));
        update(product);
        return product;
    }

    public Product readById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
