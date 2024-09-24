package com.example.blps_1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class VendorDTO {
    @NotNull(message = "Имя Продавца не может быть null")
    @Size(min = 1, max = 200, message = "Имя продавца должно быть от 1 до 200 символов")
    private String name;
}
