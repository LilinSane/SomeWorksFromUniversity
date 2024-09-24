package com.example.blps_1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClientDTO {
    @NotBlank(message = "Имя пользователя не должно состоять только из пробельных символов")
    @NotEmpty(message = "Имя пользователя не должно быть пустым")
    private String name;
    @NotBlank(message = "Почта не может быть пустой")
    @Email(message = "Поле не соответствует формату почты")
    private String mail;
    @NotBlank(message = "Пароль пользователя не должно состоять только из пробельных символов")
    @NotEmpty(message = "Пароль пользователя не должно быть пустым")
    @Size(min = 8, message = "Пароль должен состоять минимум из 8 символов")
    private String password;
}
