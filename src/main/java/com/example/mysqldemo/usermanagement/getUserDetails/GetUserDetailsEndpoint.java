package com.example.mysqldemo.usermanagement.getUserDetails;

import com.example.mysqldemo.usermanagement.common.jpa.User;
import com.example.mysqldemo.usermanagement.common.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class GetUserDetailsEndpoint {

    final UserRepository userRepository;

    @GetMapping("{id}")
    public User getUserDetails(@PathVariable("id") Long userId) {
        return userRepository.findById( userId ).get();
    }

}
