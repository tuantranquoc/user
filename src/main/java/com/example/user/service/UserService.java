package com.example.user.service;

import com.example.user.dto.UserDto;
import com.example.user.dto.UserInfo;

public interface UserService {
    public boolean login(String username, String password);
    public boolean createUser(UserDto userDto);
    public UserInfo getUser(String username); 
}
