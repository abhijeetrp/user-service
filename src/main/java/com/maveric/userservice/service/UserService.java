
package com.maveric.userservice.service;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService{
    List<User> findByEmail(String email);
}
