package com.example.usersPipeline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String imageURL;

    public Users() {
    }

    public Users(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
