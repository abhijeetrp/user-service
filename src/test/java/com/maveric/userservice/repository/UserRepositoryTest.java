package com.maveric.userservice.repository;

import com.maveric.userservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    void findByEmail() {
        User u=userRepository.findByEmail("a@gmail.com");
        Assertions.assertNotNull(u);
    }
}