package com.example.cms.controller;

import com.example.cms.controller.dto.UserDto;
import com.example.cms.model.entity.User;

import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository) { this.repository = repository; }

    @PostMapping("/signup")
    User createUser(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setUserName(userDto.getUserName());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());

        if (repository.findById(newUser.getUserName()).isPresent()) {
            throw new IllegalStateException("Hold up! Someone already has this username... Unlucky!");
        }
        return repository.save(newUser);
    }

    @GetMapping("/users/{username}")
    User retrieveUser(@PathVariable("username") String username) {
        return repository.findUser(username);
    }

/* CHECK IF EVER USED
    @GetMapping("/users")
    List<User> retrieveAllUsers() { return repository.findAll(); }

 */

    @PutMapping("/users/{username}/change")
    User updatePassword(@RequestBody UserDto userDto, @PathVariable("username") String username) {
        return repository.findById(username)
                .map(user -> {
                    user.setPassword(userDto.getPassword());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUserName(username);
                    newUser.setPassword(userDto.getPassword());
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{username}/delete")
    void deleteUser(@PathVariable("username") String userName) {
        repository.deleteById(userName);
    }
}
