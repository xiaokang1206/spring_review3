package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

/*<bean id="UserService" class="com.itheima.service.impl.UserServiceImpl">*/
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Autowired//按照数据类型从spring容器中进行匹配
   // @Qualifier("userDao") //按照明名称注入，和autowired一起使用
    //@Resource(name="userDao")//Autowired+qualifer
    private UserDao userDao;

      @Value("${jdbc.driver}")
      private String driver;

      @Resource(name="dataSource")//测试@Bean注解
      private DataSource dataSource;

    @Override
    public void save() {
       userDao.save();
        System.out.println(driver);
        System.out.println("dataSource："+dataSource);//测试@Bean注解
     }
}
