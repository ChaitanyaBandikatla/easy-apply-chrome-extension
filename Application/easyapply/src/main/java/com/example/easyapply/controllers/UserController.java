package com.example.easyapply.controllers;

import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/user")
    public String User() {

        UserDetailsEntity user = new UserDetailsEntity();
        user.setPassword("test");
        user.setEmail("test1@test.com");
        user.setUsername("test1");

        userService.createUser(user);

        return "Hey user!";
    }
}
