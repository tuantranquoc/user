package com.example.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.user.dto.UserDto;
import com.example.user.dto.UserInfo;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean login(String username, String password) {
        if (username == null || password == null) return false;
        User user = userRepository.getUserByUserName(username);
        log.info("This is user: " + user + " " + passwordEncoder.matches(password, user.getPassword()));
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean createUser(UserDto userDto) {
        User user = User.builder().username(userDto.getUsername()).password(passwordEncoder.encode(userDto.getPassword())).build();
        userRepository.saveAndFlush(user);
        return true;
    }

    @Override
    public UserInfo getUser(String username) {
        log.info("username: " + username);
        User user = userRepository.getUserByUserName(username);
        log.info("user: " + user);

        if (user == null) return null;
        return UserInfo.userTransformation(user);
    }
}
