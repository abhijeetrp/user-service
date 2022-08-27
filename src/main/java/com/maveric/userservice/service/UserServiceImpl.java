//package com.maveric.userservice.service;
//
//
//import com.maveric.userservice.model.User;
//import com.maveric.userservice.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//    private UserRepository userRepository;
//
//
//
//    public UserServiceImpl(UserRepository userRepository) {
//        super();
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmail(username);
//
//}
