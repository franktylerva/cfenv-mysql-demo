package com.example.mysqldemo.usermanagement.getAllUsers;

import com.example.mysqldemo.usermanagement.common.jpa.User;
import com.example.mysqldemo.usermanagement.common.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
class ListAllUsersEndpoint {
    final UserRepository userRepository;

    @GetMapping
    public Map<String,Object> users() {
        return Map.of("users", userRepository.findAll());
    }
}
