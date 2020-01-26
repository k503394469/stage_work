package com.liu.service;

import com.liu.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> name_search(String username);
    void deleteById(Integer id);
    User findById(Integer id);
    void updateUser(User user);
}
