package com.learn.withravi.service;

import com.learn.withravi.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUser();
    UserDto updateUser(UserDto user);
    void deleteUser(Long id);

}
