package com.maveric.userservice.repository;

import com.maveric.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  // User findByEmailId(String email);
   // Optional<Object> findByEmailId();
  User findByEmail(String email);


//   List<User> findByEmail(String email);

}

