package com.example.blps_1.service;

import com.example.blps_1.dto.CategoryDTO;
import com.example.blps_1.entity.Category;
import com.example.blps_1.repository.CategoryRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    @Transactional
    public Category create(CategoryDTO categoryDTO){
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(category);
    }
    @Transactional
    public Category readByName(CategoryDTO categoryDTO) {
        return categoryRepository.findByName(categoryDTO.getName()).orElseThrow(() -> new NullPointerException("Категории с таким именем не существует"));
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(Category category) {
        categoryRepository.save(category);
    }
    @Transactional
    public Page<Category> readAll(PageRequest pageRequest) {
        return categoryRepository.findAll(pageRequest);
    }
    @Transactional
    public boolean delete (CategoryDTO categoryDTO) {
        Category category = readByName(categoryDTO);
        if(category == null){
            return false;
        }
        categoryRepository.delete(category);
        return true;
    }
    @Transactional
    public Category readById(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Category updateCategoryData(CategoryDTO categoryDTO){
        Category category = readByName(categoryDTO);
        category.setName(categoryDTO.getName());
        update(category);
        return category;
    }
}
