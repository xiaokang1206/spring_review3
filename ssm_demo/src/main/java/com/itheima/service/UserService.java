package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {


    List<User> list();

    void save(User user, long[] roleIds);

    void del(Long userId);

    User login(String username, String password);
}
