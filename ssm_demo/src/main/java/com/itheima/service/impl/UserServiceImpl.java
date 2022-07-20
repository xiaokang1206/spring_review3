package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> list() {
      List<User> userList=  userDao.findAll();
      //封装userList中的每一个User的role数据
        for (User user : userList) {
      // 获得user的iD
            Long id = user.getId();
            //将id作为参数，查询当前userID对应的Role集合数据
            List<Role> roles =   roleDao.findRoleByUserID(id);

         user.setRoles(roles);


        }

        return userList ;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,readOnly = false,propagation = Propagation.REQUIRED)//事务控制
    public void save(User user, long[] roleIds) {
        //1. 向sys_user表中存储数据
        Long userID = userDao.save(user);

        //2. 向sys_user_role表中存储数据
        userDao.saveUserRoleRel(userID,roleIds);


    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,readOnly = false,propagation = Propagation.REQUIRED)//事务控制
    public void del(Long userId) {
        //删除sys_user_role关系表
        userDao.delUserRoleRel(userId);

        //删除sys_user表
        userDao.del(userId);
    }

    @Override
    public User login(String username, String password) {

        try {
            User user=   userDao.findByUsernameAndPassword(username,password);
            return user;

        }catch (EmptyResultDataAccessException e){

            return null;
        }


    }
}
