package com.example.blps_1.controller;

import com.example.blps_1.dto.CategoryDTO;
import com.example.blps_1.entity.Category;
import com.example.blps_1.service.CategoryService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> get(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                              @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit) {
        return new ResponseEntity<>(categoryService.readAll(PageRequest.of(offset, limit)).getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.create(categoryDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.updateCategoryData(categoryDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody CategoryDTO categoryDTO) {
        if (!categoryService.delete(categoryDTO)) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
