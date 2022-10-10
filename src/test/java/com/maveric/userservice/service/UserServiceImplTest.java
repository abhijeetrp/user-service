package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
   @Mock
   private UserRepository userRepository;
   private UserServiceImpl userServiceImpl;
   @BeforeEach
   void setUp()
   {
       this.userServiceImpl= new UserServiceImpl(this.userRepository);
   }
    @Test
    void getUsers1() {
        userServiceImpl.getUsers1();
        verify(userRepository).findAll();
    }


//    @Test
//   public void getUsersTest() {
//
//
//        userServiceImpl.getUsers();
//
////        List<User> users=new ArrayList<User>();
////        users.add(new User(1,"asds","sadasd","sadasd","1234567890","abc@gmail.com","Pune","23-05-1996","MALE"));
////        users.add(new User(2,"asads","sadaasd","sadasad","1234667890","a2bc@gmail.com","Pune","23-05-1996","MALE"));
////         when(userRepository.findAll()).thenReturn(users);
////        assertEquals(2,userServiceImpl.getUsers(0,2).size());
//    }

//    @Test
//    void getUserDetails() {
//
//        int id=1;
//        List<User> users=new ArrayList<User>();
//        users.add(new User(1,"asds","sadasd","sadasd","1234567890","abc@gmail.com","Pune","23-05-1996","MALE"));
//        users.add(new User(2,"asads","sadaasd","sadasad","1234667890","a2bc@gmail.com","Pune","23-05-1996","MALE"));
//
//        int iid=1;
//
//
//        when(userRepository.findById(Long.valueOf(id))).thenReturn(users);
//        assertEquals(iid, userServiceImpl.getUserDetails(String.valueOf(iid)).getId());
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