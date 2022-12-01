package com.example.mysqldemo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@SpringBootApplication
public class MysqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDemoApplication.class, args);
	}
}

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
class UserController {
	final UserRepository userRepository;
	@GetMapping
	public List<User> users() {
		return userRepository.findAll();
	}
}

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Data
class User {
	@Id Long id;
	String email;
}

interface UserRepository extends JpaRepository<User,Long> {

}