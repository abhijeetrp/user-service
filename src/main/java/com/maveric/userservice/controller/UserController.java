package com.maveric.userservice.controller;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers(@RequestParam(defaultValue = "0")Integer page,@RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.getUsers(page,pageSize);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto= this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>( createUserDto, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public UserDto getUserDetails(@PathVariable long id) {
        return userService.getUserDetails(String.valueOf(id));
    }


    @GetMapping("/getUserByEmail/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@Valid  @PathVariable long id , @RequestBody UserDto userDto)
    {
        UserDto updateUserDto= userService.updateUser(String.valueOf(id), userDto);
        return new ResponseEntity<UserDto>( updateUserDto, HttpStatus.CREATED);

        //  return userService.updateUser(String.valueOf(id), userDto);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable long id){
        return userService.deleteUser(String.valueOf(id));
    }

}
