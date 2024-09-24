package com.example.blps_1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryDTO {
    @NotBlank(message = "Категория не можеть состоять только из пробельных символов")
    @NotEmpty(message = "Категория не можеть быть пустой")
    private String name;
}
