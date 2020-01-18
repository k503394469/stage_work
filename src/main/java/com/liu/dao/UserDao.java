package com.liu.dao;

import com.liu.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void deleteById(Integer id);
    User findById(Integer id);
}
