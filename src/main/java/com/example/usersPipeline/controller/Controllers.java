package com.example.usersPipeline.controller;

import com.example.usersPipeline.models.Users;
import com.example.usersPipeline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class Controllers {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, @RequestBody Users user) throws IOException {
        return userService.uploadToFileSystem(file,user);

    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getImage(@PathVariable(value = "name",required = false) String iName) throws IOException {
        byte[] imageData = userService.downloadImage(iName);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
