package com.example.mysqldemo.usermanagement.getUserDetails;

import com.example.mysqldemo.usermanagement.common.jpa.User;
import com.example.mysqldemo.usermanagement.common.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetUserDetailsEndpoint.class)
class GetUserDetailsEndpointTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetUserDetailsEndpoint() throws Exception {

        var john = User.builder()
                .id(1L)
                .email("johndoe@gmail.com")
                .build();

        when(userRepository.findById(john.getId())).thenReturn(Optional.of(john));

        mvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect( jsonPath("$.user.id", is(1) ) )
                .andExpect( jsonPath("$.user.email", is("johndoe@gmail.com") ) );
    }

}