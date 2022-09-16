package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    void getUsers() {

        List<UserDto> userDtos= userService.getUsers(1,1);

        //assertNotNull(userDtos);
        assert(userDtos.size()>0);
    }

//    @Test
//    void getUserDetails() {
//
//    }
//
//    @Test
//    void createUser() {
//    }
//
//    @Test
//    void getUserByEmail() {
//    }
//
//    @Test
//    void deleteUser() {
//    }
//
//    @Test
//    void updateUser() {
//    }
}