package com.maveric.userservice;

import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
//		User user = new User(11L,"Abhijeet","Pawar","Raosaheb","1234567890","abc@gmail.com","Pune","23/05/1996","Male","12346");
//		 User user = new User();
//		userRepository.save(user);
	}
}
