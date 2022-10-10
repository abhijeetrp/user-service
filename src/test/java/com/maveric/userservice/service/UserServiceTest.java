package com.maveric.userservice.service;

import com.maveric.userservice.constants.Gender;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

   @Autowired
    private User user;

    @BeforeEach
    public void setup(){
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        user = User.builder()
                .id(1L)
                .firstName("Rashmi")
                .lastName("Vsad")
                .middleName("Msadsa")
                .phoneNumber("1234567890")
                .email("rash@gmail.com")
                .address("Bangalore")
                .dateOfBirth("23/05/1996")
                .gender(Gender.FEMALE)
                .password("123456")
                .build();
    }

    @Test
    void getUsers() {
    }

    @DisplayName("JUnit test for saveEmployee method")
    @Test
    void createUser() {
        BCryptPasswordEncoder encoded = new BCryptPasswordEncoder();
        User user=new User();
        user.setId(1L);
        user.setFirstName("Rashmi");
        user.setLastName("V");
        user.setMiddleName("M");
        user.setEmail("rash@mail.com");
        user.setPhoneNumber("1234567890");
        user.setGender(Gender.FEMALE);
        user.setAddress("bang");
        user.setDateOfBirth("2022-06-08");
        //  user.setPassword(encoded.encode("1234"));
        user.setPassword("1234");
        given(userRepository.save(user)).willReturn(user);
        UserDto userDto= userService.convertEntityToDto(user);

        UserDto responseData=userService.createUser(userDto);
        assertThat(responseData).isNotNull();
//        User userInfo = userRepository.save(user);
//        Assertions.assertNotNull(userInfo);

//        given(userRepository.findByEmail(user.getEmail()))
//                .willReturn(Optional.empty());

       // given(userRepository.save(user)).willReturn(user);



        // when -  action or the behaviour that we are going test
//        given(userRepository.save(user)).willReturn(user);
//
//        UserDto userDto= userService.convertEntityToDto(user);
//
//        UserDto savedUser = userService.createUser(userDto);
//        // then - verify the output
//        assertThat(savedUser).isNotNull();
    }

    @Test
    void getUserDetails() {
    }

    @Test
    void getUserByEmail() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}