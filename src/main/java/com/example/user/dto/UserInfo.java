package com.example.user.dto;

import com.example.user.model.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserInfo {
    String username;

    public static UserInfo userTransformation(User user){
        UserInfo userInfo = UserInfo.builder().username(user.getUsername()).build();
        return userInfo;
    }
}
