package com.itheima.demo;

import com.itheima.dao.UserDao;
import com.itheima.sercice.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
       // ApplicationContext app=new FileSystemXmlApplicationContext("D:\\develop\\spring_review\\spring_ioc\\src\\main\\resources\\applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
     //   UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
