package com.example.myphotoapp.resource;

import com.example.myphotoapp.model.User;
import com.example.myphotoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/user1")
    public User getUser(){
        return userService.getUser();
    }

    //save data from user, requestbody because it will take it in JSON format
    @PostMapping("/user1")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getAllUsers") //Get all the users with the userId
    public List<User> getAllUsers(){
        return userService.getAllUsers() ;
    }

    @GetMapping("/user/{userId}") //Get a specific user
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable("userId")int userId, @RequestBody User user){
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/user1")
    public User deleteUser(@RequestParam(name = "userId") int userId){
        return userService.deleteUser(userId);
    }




}
