package com.learn.withravi.service;

import com.learn.withravi.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(Long id);

}
