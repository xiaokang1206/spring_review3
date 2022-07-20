package com.itheima.sercice.impl;

import com.itheima.dao.UserDao;
import com.itheima.sercice.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserServiceImpl implements UserService {

    private UserDao userDao;

   /* public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }*/

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public void save() {
        userDao.save();
    }
}
