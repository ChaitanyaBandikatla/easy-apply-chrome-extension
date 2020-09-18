package com.example.easyapply.ServicesTests;

import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.models.UserModel;
import com.example.easyapply.repositories.UserRepository;
import com.example.easyapply.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {
    private UserRepository userRepository;
    private UserDetailsEntity userDetailsEntity;
    private UserModel userModel;
    private UserService userService;

    @BeforeEach
    public void initialize(){
        this.userRepository = Mockito.mock(UserRepository.class);
        this.userDetailsEntity = new UserDetailsEntity();
        this.userModel = new UserModel();
        this.userService = new UserService(userRepository);
        this.userModel.setUsername("test");
        this.userModel.setPassword("test");
        this.userModel.setEmail("test");
    }

    @Test
    public void test_createUser_success(){
        userDetailsEntity.setUserId(1);
        when(userRepository.save(org.mockito.Matchers.any(UserDetailsEntity.class))).thenReturn(userDetailsEntity);
        Optional<Integer> userId = this.userService.createUser(userModel);
        assertEquals(1, userId.get().intValue());
    }

    @Test
    public void test_getUser_success(){
        userDetailsEntity.setUserId(1);
        when(userRepository.findById(1)).thenReturn(Optional.of(userDetailsEntity));
        Optional<UserModel> userModel = this.userService.getUser(1);
        assertTrue(userModel.isPresent());
    }

    @Test
    public void test_loginUser_success(){
        userDetailsEntity.setUserId(1);
        userDetailsEntity.setUsername("test");
        userDetailsEntity.setPassword("test");
        userModel.setUsername("test");
        userModel.setPassword("test");
        when(userRepository.findUserByUserName(org.mockito.Matchers.any(String.class))).thenReturn(Optional.of(userDetailsEntity));
        Optional<Integer> userId = this.userService.loginUser(userModel);
        assertTrue(userId.isEmpty());
    }
}
