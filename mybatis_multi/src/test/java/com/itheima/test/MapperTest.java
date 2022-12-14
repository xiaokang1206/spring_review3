package com.itheima.test;


import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MapperTest {



//查询全部
    @Test
    public void test1() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

      List<Order> order=  mapper.findAll();

        System.out.println(order);
    }

    //查询全部
    @Test
    public void test2() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);

        }
    }

    //查询全部
    @Test
    public void test3() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.findUserAndRole();
        for (User user : userList) {

            System.out.println(user);
        }

    }
}
