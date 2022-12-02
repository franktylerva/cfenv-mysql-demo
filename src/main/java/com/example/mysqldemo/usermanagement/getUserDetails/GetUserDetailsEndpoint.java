package com.example.mysqldemo.usermanagement.getUserDetails;

import com.example.mysqldemo.usermanagement.common.jpa.User;
import com.example.mysqldemo.usermanagement.common.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class GetUserDetailsEndpoint {

    final UserRepository userRepository;

    @GetMapping("{id}")
    public Map<String,Object> getUserDetails(@PathVariable("id") Long userId) {
        return Map.of("user", userRepository.findById( userId ).get() );
    }
}
