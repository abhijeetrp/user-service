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

    // build create-user Rest API
    //*****************************************************************************************************

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }


}