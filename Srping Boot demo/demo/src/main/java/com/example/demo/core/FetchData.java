package com.example.demo.core;

import com.example.demo.interfaces.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration("fetchData")
public class FetchData {

    @Autowired
    private MongoTemplate database;

    public User fetchUser(String id){
        return database.findById(id,User.class);
    }

    public void createUser(String id){
        User user = new User(id,"John","123");
        database.save(user);
    }

    public List<User> getUsers(){
        return database.findAll(User.class);
    }
}
