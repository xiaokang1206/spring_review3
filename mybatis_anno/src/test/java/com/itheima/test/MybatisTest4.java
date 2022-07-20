package com.itheima.test;

import com.itheima.domain.User;
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

public class MybatisTest4 {

      private UserMapper mapper;
    @Before
    public void init() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

         mapper = sqlSession.getMapper(UserMapper.class);
    }




    //一对多查询测试
    @Test
    public void testfindAll(){

        List<User> userAndRoleAll = mapper.findUserAndRoleAll();
        for (User user : userAndRoleAll) {

            System.out.println(user);
        }



    }


}
