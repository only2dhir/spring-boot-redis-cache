package com.devglan.springbootrediscache.controller;

import com.devglan.springbootrediscache.model.User;
import com.devglan.springbootrediscache.repo.RedisUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RedisUserRepository userRepository;

    @PostMapping
    public User save(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.findById(id);
    }

    @PutMapping
    public User update(@RequestBody User user){
        userRepository.update(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.delete(id);
        return id;
    }
}
