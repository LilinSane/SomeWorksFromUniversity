package com.example.blps_1.controller;

import com.example.blps_1.dto.CategoryDTO;
import com.example.blps_1.dto.ProductDTO;
import com.example.blps_1.entity.Product;
import com.example.blps_1.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody @NotNull ProductDTO productDTO) {
        Product product = productService.create(productDTO);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> get(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                             @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100)Integer limit){
        return new ResponseEntity<>(productService.readAll(PageRequest.of(offset, limit)).getContent(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.updateProductData(id, productDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody ProductDTO productDTO) {
        if(!productService.delete(productDTO)){
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> getByCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(productService.readAllByCategory(categoryDTO), HttpStatus.OK);
    }
}
