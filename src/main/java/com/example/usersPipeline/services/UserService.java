package com.example.usersPipeline.services;

import com.example.usersPipeline.models.Users;
import com.example.usersPipeline.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> addUser(Users user) {
        userRepo.save(user);
        return ResponseEntity.ok().build();
    }
}
