package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.Data
@Document("data")
public class Data {
    @Id
    private String id= "21";
    @Indexed(unique = true)
    private String name = "hello";
}
