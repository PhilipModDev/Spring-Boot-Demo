package com.example.demo.interfaces;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@lombok.Data
@Document
@Component
public class User {



    @Id
    private String id;

    public User(String id,String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public User() {
    }

    private String name;
    private String password;
}
