package com.maveric.userservice.service;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exception.ResourceNotFoundException;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    public List<UserDto>  getUsers(Integer page,Integer pageSize)
    {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> Users = userRepository.findAll(pageable);
        return   Users
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    @Override
    public UserDto getUserDetails(String id) {
        return userRepository.findById(Long.valueOf(id)).map(this::convertEntityToDto).get();
    }
    @Override
    public UserDto createUser(UserDto userDto) {

        User user= convertDtoToEntity(userDto);
        User newuser= userRepository.save(user);

        UserDto userresponce= convertEntityToDto(newuser);
        return userresponce;
    }
    @Override
    public UserDto getUserByEmail(String email) {
          User user = userRepository.findByEmail(email);
          return convertEntityToDto(user);
    }
    @Override
    public String deleteUser(String id) {
                userRepository.deleteById(Long.valueOf(id));
        return "User deleted successfully.";
    }

    @Override
    public UserDto updateUser(String id, UserDto userDto) {
        User updateUser = userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("User not exit with id" +id));
        updateUser.setFirstName(userDto.getFirstName());
        updateUser.setLastName(userDto.getLastName());
        updateUser.setMiddleName(userDto.getMiddleName());
        updateUser.setPhoneNumber(userDto.getPhoneNumber());
        updateUser.setEmail(userDto.getEmail());
        updateUser.setAddress(userDto.getAddress());
        updateUser.setDateOfBirth(userDto.getDateOfBirth());
        updateUser.setGender(userDto.getGender());
        updateUser.setId(userDto.getId());
        userRepository.save(updateUser);
        return convertEntityToDto(updateUser);
    }



    private UserDto convertEntityToDto(User user){
        UserDto  userDto =new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setGender(user.getGender());
        userDto.setId(user.getId());
      return userDto;
    }
    private User convertDtoToEntity(UserDto userDto){
        User user =new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMiddleName(userDto.getMiddleName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setGender(userDto.getGender());
        user.setId(userDto.getId());
        return user;
    }
}