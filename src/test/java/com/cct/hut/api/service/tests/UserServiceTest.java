package com.cct.hut.api.service.tests;

import com.cct.hut.api.model.User;
import com.cct.hut.api.repository.UserRepository;
import com.cct.hut.api.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        User user = new User();
        user.setEmail("fabi@gmail.com");

        Mockito.when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(user);
    }
    @Test
    public void whenValidEmail_thenUserShouldBeFound(){
        String email = "fabi@gmail.com";
        User found = userService.findByEmail(email);

        Assertions.assertEquals(email, found.getEmail());
    }
}
