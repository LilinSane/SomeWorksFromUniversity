package com.example.blps_1.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ProductDTO {
    @NotNull(message = "Название продукта не может быть null")
    @Size(min = 1, max = 200, message = "Название продукта должно быть от 1 до 200 символов")
    private String name;

    @NotNull(message = "Количество не может быть пустым")
    @Min(value = 1, message = "Количество должно быть больше 0")
    private Integer amount;

    @NotNull(message = "Category ID не может быть null")
    private Long categoryId;

    @NotNull(message = "Vendor ID не может быть null")
    private Long vendorId;
}
