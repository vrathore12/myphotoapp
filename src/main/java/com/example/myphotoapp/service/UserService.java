package com.example.myphotoapp.service;

import com.example.myphotoapp.model.User;
import com.example.myphotoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {

        return userRepository.save(user);

    }

        public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getByAddress(String address) {
        return userRepository.findAllByAddress(address);
    }


    public User getById(String userId) {
        return userRepository.findById(userId).get();
    }
}
