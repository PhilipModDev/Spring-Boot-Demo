package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DataRepository extends MongoRepository<Data,String> {
    Optional<Data> findDataByName(String name);
}
