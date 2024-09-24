package com.example.blps_1.repository;

import com.example.blps_1.entity.Category;
import com.example.blps_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    List<Product> findProductByCategory(Category category);
}
