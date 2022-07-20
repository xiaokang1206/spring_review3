package com.itheima.test;

import com.itheima.domain.Order;
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

public class MybatisTest2 {

      private  OrderMapper mapper;
    @Before
    public void init() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

         mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testSave(){

    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testDelete(){


    }

    @Test
    public void testfindById(){


    }

    @Test
    public void testfindAll(){

        List<Order> orderList = mapper.findAll();
        System.out.println(orderList);


    }


}
