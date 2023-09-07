package org.example.controller;

import org.example.data.model.User;
import org.example.dto.UserRequest;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping({"/registerNewUser"})
    public void registerNewUser(@RequestBody UserRequest request){
        userService.registerNewUser(request);
    }
}
