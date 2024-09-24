package com.example.lab4server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Lab4ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4ServerApplication.class, args);
    }

}
