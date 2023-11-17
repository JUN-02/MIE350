package com.example.cms.controller;

import com.example.cms.controller.dto.UserDto;
import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.User;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository) {this.repository = repository;}

    @PostMapping("/signup")
    User createUser(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setUserName(userDto.getUserName());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());
        return repository.save(newUser);
    }


    @PostMapping("/login")
    List<User> retrieveUser(@RequestBody String userName, @RequestBody String password) {
        return repository.findUser(userName,password);
    }
    @PutMapping("/login/update")
    List<User> updatePassword(@RequestBody User newUser, @RequestBody String userName, @RequestBody String newPassword) {
        return repository.findUser(userName,newPassword);
                /*.map(user -> {
                    user.setUserName(newUser.getUserName());
                    user.setPassword(newUser.getPassword());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setPassword(newPasswordd);
                    return repository.save(newUser);
                });*/
    }
}
