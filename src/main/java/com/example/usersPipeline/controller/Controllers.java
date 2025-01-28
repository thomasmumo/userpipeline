package com.example.usersPipeline.controller;

import com.example.usersPipeline.models.Users;
import com.example.usersPipeline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }
}
