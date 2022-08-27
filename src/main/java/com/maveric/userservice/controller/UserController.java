package com.maveric.userservice.controller;

import com.maveric.userservice.exception.ResourceNotFoundException;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // build return user list Rest API
    //*****************************************************************************************************

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }


    // build create-user Rest API
    //*****************************************************************************************************

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // build get user by id REST API
    //*****************************************************************************************************

    @GetMapping("{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not exit with id" + id));
        return ResponseEntity.ok(user);
    }

}
