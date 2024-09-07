package com.sa.sweeterassociation.controller;

import com.sa.sweeterassociation.model.User;
import com.sa.sweeterassociation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public User getOne(@PathVariable("username") String username){
        return userRepository.findByUsername("frank");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping()
    public void putUser(@RequestBody User user){
        userRepository.save(user);
    }

}
