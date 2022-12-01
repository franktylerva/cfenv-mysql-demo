package com.example.mysqldemo.usermanagement.listAllUsers;

import com.example.mysqldemo.usermanagement.common.jpa.User;
import com.example.mysqldemo.usermanagement.common.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
class ListAllUsersEndpoint {
    final UserRepository userRepository;

    @GetMapping
    public List<User> users() {
        return userRepository.findAll();
    }
}
