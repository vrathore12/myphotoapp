package com.example.myphotoapp.repository;

import com.example.myphotoapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByAddress(String address);

}
