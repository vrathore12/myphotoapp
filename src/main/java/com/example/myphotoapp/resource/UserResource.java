package com.example.myphotoapp.resource;

import com.example.myphotoapp.Exception.RestrictedInfoException;
import com.example.myphotoapp.model.User;
import com.example.myphotoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/find")
    public List<User> getByAddress(@RequestParam(name="address") String address) throws RestrictedInfoException {
        if (address.equalsIgnoreCase("area51")){
            throw new RestrictedInfoException();
        }
        return userService.getByAddress(address);
    }


    @GetMapping("/find-by-id")
    public User getById(@RequestParam("userId") String userId){
        return userService.getById(userId);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userId") String userId) {
        userService.deleteUser(userId);
    }



}
