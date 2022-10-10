
package com.maveric.userservice.service;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService{

   public List<UserDto> getUsers(Integer page,Integer pageSize);
   public UserDto createUser(UserDto userDto);
   public UserDto getUserDetails(String id);
   public UserDto getUserByEmail(String email);
   public UserDto updateUser(String id, UserDto userDto);
   public String deleteUser(String id);


}
