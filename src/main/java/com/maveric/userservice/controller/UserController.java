package com.maveric.userservice.controller;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    // build return user list Rest API
    //*****************************************************************************************************
    @GetMapping
    public List<UserDto> getUsers(@RequestParam(defaultValue = "0")Integer page,@RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getUsers(page,pageSize);
    }
    // build create-user Rest API
    //*****************************************************************************************************
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
    // build get user by id REST API
    //*****************************************************************************************************
    @GetMapping("{id}")
    public UserDto getUserDetails(@PathVariable long id) {
        return userService.getUserDetails(String.valueOf(id));
    }

    // build get user by emailID REST API
    //*****************************************************************************************************
    @GetMapping("/getUserByEmail/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    //  build update user Rest API
    //*****************************************************************************************************
    @PutMapping("{id}")
    public UserDto updateUser(@PathVariable long id , @RequestBody UserDto userDto)
    {
          return userService.updateUser(String.valueOf(id), userDto);
    }
    // build delete user REST API
    //*****************************************************************************************************
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable long id){
        return userService.deleteUser(String.valueOf(id));
    }

}
