package com.example.mysqldemo.usermanagement.getAllUsers;

import com.example.mysqldemo.usermanagement.common.jpa.User;
import com.example.mysqldemo.usermanagement.common.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ListAllUsersEndpoint.class)
class ListAllUsersEndpointTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testListAllUsersEndpoint() throws Exception {

        var john = User.builder()
                .id(1L)
                .email("johndoe@gmail.com")
                .build();

        var jane = john.toBuilder()
                .id(2L)
                .email("janedoe@gmail.com")
                .build();

        when(userRepository.findAll()).thenReturn(List.of(john, jane));

        mvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect( jsonPath("$.users[0].id", is(1) ) )
                .andExpect( jsonPath("$.users[0].email", is("johndoe@gmail.com") ) )
                .andExpect( jsonPath("$.users[1].id", is(2) ) )
                .andExpect( jsonPath("$.users[1].email", is("janedoe@gmail.com") ) );

    }

}