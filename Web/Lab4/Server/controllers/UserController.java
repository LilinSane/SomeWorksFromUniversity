package com.example.lab4server.controllers;


import com.example.lab4server.database.domain.User;
import com.example.lab4server.database.repository.UserRepository;
import com.example.lab4server.dto.UserDTO;
import com.example.lab4server.validators.MD5Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO){
        User user = userRepository.getUserByEmail(userDTO.getEmail());
        if (user == null){return false;}
        String hash = MD5Custom.getHash(userDTO.getPassword());
        return user.getPassword().equals(hash);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(MD5Custom.getHash(userDTO.getPassword()));
        User dbUser = userRepository.getUserByEmail(userDTO.getEmail());
        if(dbUser != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
