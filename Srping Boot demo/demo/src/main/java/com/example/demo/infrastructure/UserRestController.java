package com.example.demo.infrastructure;

import com.example.demo.core.FetchData;
import com.example.demo.interfaces.User;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Resource(name = "fetchData")
    public FetchData data;

    @GetMapping("{id}")
    public User get(@PathVariable String id){
        data.createUser(id);
       return data.fetchUser(id);
    }

    @GetMapping
    public List<User> get(){
        return data.getUsers();
    }
}
