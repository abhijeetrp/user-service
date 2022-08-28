package com.maveric.userservice.service;

import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}