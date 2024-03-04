package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.UserDto;
import com.example.user.dto.UserInfo;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/user")
    // @RequestBody
    public boolean createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping("/user")
    public UserInfo getUser(@RequestParam String username){
        return userService.getUser(username);
    }

    @PostMapping("/login")
    public boolean getMethodName(@RequestBody UserDto userDto) {
        log.info("userDto: " + userDto.getUsername() + userDto.getPassword());
        return userService.login(userDto.getUsername(), userDto.getPassword());
    }
    
}
