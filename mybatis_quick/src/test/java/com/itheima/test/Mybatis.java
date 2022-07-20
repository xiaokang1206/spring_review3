package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {


    //获得核心配置文件
    InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
    //获取Session工厂对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //获得session会话对象
    SqlSession sqlSession = sqlSessionFactory.openSession(true);//设置为true，则自动提交事务

    public Mybatis() throws IOException {
    }

    @Test
    //查询操作
    public void test1() throws IOException {


        //执行操作 参数：namespace
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        sqlSession.close();


    }

    @Test
    //插入操作
    public void test2() throws IOException {
        //模拟user对象
         User user=new User();
         user.setUsername("lucy");
         user.setPassword("abc");

        sqlSession.insert("userMapper.save",user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();


    }


    @Test
    //修改操作
    public void test3() throws IOException {
        //模拟user对象
        User user=new User();
        user.setId(6);
        user.setUsername("proch");
        user.setPassword("123");

        sqlSession.update("userMapper.update",user);

        //释放资源
        sqlSession.close();
    }

    @Test
    //删除操作
    public void test4() throws IOException {

        sqlSession.update("userMapper.delete",6);
         //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    //查询1ge操作
    public void test5() throws IOException {


        //执行操作 参数：namespace
        User user = sqlSession.selectOne("userMapper.findById",4);
        //打印数据
        System.out.println(user);
        sqlSession.close();


    }
}
