package com.example.easyapply.ControllerTests;

import com.example.easyapply.controllers.UserController;
import com.example.easyapply.models.Response;
import com.example.easyapply.models.UserModel;
import com.example.easyapply.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTests {

    private UserModel userModel;
    private UserController userController;
    private UserService userService;

    @BeforeEach
    void initialize(){
        this.userService = Mockito.mock(UserService.class);
        this.userController = new UserController(this.userService);
        this.userModel = new UserModel();
    }

    @Test
    public void test_createUser_successful(){
        when(this.userService.createUser(this.userModel)).thenReturn(Optional.of(1));
        ResponseEntity<Response> responseEntity = this.userController.createUser(userModel);
        assertEquals(1, ((UserModel) responseEntity.getBody().getResponse()).getUserId());
    }

    @Test
    public void test_createUser_failed(){
        when(this.userService.createUser(this.userModel)).thenReturn(Optional.empty());
        ResponseEntity<Response> responseEntity = this.userController.createUser(userModel);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }

    @Test
    public void test_loginUser_failed(){
        when(this.userService.loginUser(this.userModel)).thenReturn(Optional.empty());
        ResponseEntity<Response> responseEntity = this.userController.loginUser(userModel);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }

    @Test
    public void test_loginUser_successful(){
        when(this.userService.loginUser(this.userModel)).thenReturn(Optional.of(1));
        ResponseEntity<Response> responseEntity = this.userController.loginUser(userModel);
        assertEquals(1, ((UserModel) responseEntity.getBody().getResponse()).getUserId());
    }

    @Test
    public void test_getUser_successful(){
        this.userModel.setUserId(1);
        when(this.userService.getUser(1)).thenReturn(Optional.of(this.userModel));
        ResponseEntity<Response> responseEntity = this.userController.getUser(1);
        assertEquals(1, ((Optional<UserModel>) responseEntity.getBody().getResponse()).get().getUserId());
    }

    @Test
    public void test_getUser_failed(){
        when(this.userService.getUser(1)).thenReturn(Optional.empty());
        ResponseEntity<Response> responseEntity = this.userController.getUser(1);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getBody().getHttpStatus());
    }
}
