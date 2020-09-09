package com.example.easyapply.controllers;

import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.models.Response;
import com.example.easyapply.models.UserModel;
import com.example.easyapply.services.UserService;
import com.example.easyapply.utilities.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Creates user for given user model
     * @param userModel
     * @return
     */
    @RequestMapping(value = "/user")
    public ResponseEntity<Response> createUser(@RequestBody UserModel userModel) {
        Optional<Integer> userId = userService.createUser(userModel);
        if(userId.isPresent()){
            userModel.setUserId(userId.get());
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, userModel), HttpStatus.OK);
        }

        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "Creation of user failed"), HttpStatus.OK);
    }

    /**
     * Returns user DTO for user id
     * @param userId
     * @return
     */
    @RequestMapping("/user/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") int userId){
        Optional<UserModel> userModel = userService.getUser(userId);
        if(userModel.isPresent()){
            return new ResponseEntity<Response>(new Response(HttpStatus.OK, userModel), HttpStatus.OK);
        }

        ApplicationLogger.getInstance().logTrace("User not found");
        return new ResponseEntity<Response>(new Response(HttpStatus.BAD_REQUEST, "User not found"), HttpStatus.OK);
    }
}
