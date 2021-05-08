package com.example.myphotoapp.service;

import com.example.myphotoapp.model.User;
import com.example.myphotoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(){
        return  userRepository.getUser();
    }
}
