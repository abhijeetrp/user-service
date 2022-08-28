package com.maveric.userservice.controller;

import com.maveric.userservice.exception.ResourceNotFoundException;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import com.maveric.userservice.service.UserService;
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
    @Autowired
    private UserService userService;

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

    //  build update user Rest API
    //*****************************************************************************************************

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id ,@RequestBody User userDetails)
    {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exit with id" +id));
        updateUser.setFirstName(userDetails.getFirstName());
        updateUser.setLastName(userDetails.getLastName());
        updateUser.setMiddleName(userDetails.getMiddleName());
        updateUser.setPhoneNumber(userDetails.getPhoneNumber());
        updateUser.setEmail(userDetails.getEmail());
        updateUser.setAddress(userDetails.getAddress());
        updateUser.setDateOfBirth(userDetails.getDateOfBirth());
        updateUser.setGender(userDetails.getGender());
        updateUser.setId(userDetails.getId());
        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    // build delete user REST API
    //*****************************************************************************************************

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>  deleteUser(@PathVariable long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id : " +id));
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    // build get user by emailID REST API
    //*****************************************************************************************************
    @GetMapping("/getUserByEmail/{email}")
    public List<User> getUserByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
}
