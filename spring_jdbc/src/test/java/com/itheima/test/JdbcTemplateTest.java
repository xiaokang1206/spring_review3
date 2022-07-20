package com.itheima.test;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {

     @Test
    public void test1() throws PropertyVetoException {
//创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        //JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        int row = jdbcTemplate.update("insert into account(name,money) values(?,?)", "tom", 500);
        System.out.println(row);

    }
    @Autowired
    private  JdbcTemplate jdbcTemplate;
    //spring产生jdbctemplate
    @Test
    public void test2() throws PropertyVetoException {
        int rom = jdbcTemplate.update("insert into account(name,money) values(?,?)", "hh", 500);
        System.out.println(rom);

    }

}
