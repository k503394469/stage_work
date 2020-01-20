package com.liu.service;

import com.liu.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void deleteById(Integer id);
    User findById(Integer id);
    void updateUser(User user);
}
