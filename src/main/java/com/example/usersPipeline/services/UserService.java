package com.example.usersPipeline.services;

import com.example.usersPipeline.models.Users;
import com.example.usersPipeline.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class UserService {

    private final String FOLDER_PATH = "https://www.terabox.com/main?category=all&path=%2FTIBAPROFILES";
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> addUser(Users user) {
        return null;
    }

    public ResponseEntity<?> uploadToFileSystem(MultipartFile file, Users user) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();


        Users fileData = new Users();
        fileData.setName(user.getName());

        fileData.setImageURL(filePath);
        userRepo.save(fileData);

        file.transferTo(new File(filePath));
        return ResponseEntity.ok().build();
    }

    public byte[] downloadImage(String username) throws IOException {
        Optional<Users> fileData = userRepo.findByName(username);
        String filePath = fileData.get().getImageURL();
        byte[] images = Files.readAllBytes(new  File(filePath).toPath());
        return images;
    }
}




