package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatis {

private UserMapper mapper;

    @Before
    public void before() throws IOException {

        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

       mapper = sqlSession.getMapper(UserMapper.class);


    }

    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("cat");
        user.setPassword("455");

        mapper.save(user);



    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        mapper.update(user);

    }

    @Test
    public void testDelete(){


        mapper.delete(10);
    }

    @Test
    public void testfindById(){


        User user = mapper.findById(1);
        System.out.println(user);

    }

    @Test
    public void testfindAll(){


        List<User> userList = mapper.findAll();
        System.out.println(userList);


    }

}
