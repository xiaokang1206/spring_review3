package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {

        List<User> userList = jdbcTemplate.query("select * from sys_user ", new BeanPropertyRowMapper<User>(User.class));

        return userList;
    }

    //保存user数据
    @Override
    public Long save(final User user) {
     //  jdbcTemplate.update("insert into user values(?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        //创建PrepareStatementCreator
        PreparedStatementCreator creator=new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成有个PrepareStatement的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

                preparedStatement.setObject(1,null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());

                return preparedStatement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder=new GeneratedKeyHolder();

        jdbcTemplate.update(creator,keyHolder);

        //获得生成的主键
        long userId = keyHolder.getKey().longValue();
        return userId; //返回当前保存用户的id 该id是数据库自动生成的

    }

    //保存用户数据和用户对应的角色信息
    @Override
    public void saveUserRoleRel(Long userId, long[] roleIds) {

        for (long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);

        }

    }
    //删除关系表

    @Override
    public void delUserRoleRel(Long userId) {
                jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }
    //删除user表
    @Override
    public void del(Long userId) {

        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {

            User user = jdbcTemplate.queryForObject("select * from sys_user where username = ? and password =?",
                    new BeanPropertyRowMapper<User>(User.class), username, password);

            return user;


        }






}
