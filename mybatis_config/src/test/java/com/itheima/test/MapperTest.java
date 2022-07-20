package com.itheima.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapperTest {

    @Test
    public void test2() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      //执行保存
        User user=new User();
        user.setUsername("ceshi");
        user.setPassword("abc");
        user.setBirthday(new Date());

        mapper.save(user);
        sqlSession.commit();
        sqlSession.commit();

    }
    @Test
    public void test3() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行保存
        User user = mapper.findById(5);
        System.out.println("user中的birthday："+user.getBirthday());

        sqlSession.commit();
        sqlSession.commit();

    }
//查询全部
    @Test
    public void test4() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapperConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //设置分页相关参数  当前页 每页显示条数
        PageHelper.startPage(1,2);


        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获取与分页相关的参数
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每页显示条数"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否是第一页"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页"+pageInfo.isIsLastPage());


        sqlSession.close();
    }
}
