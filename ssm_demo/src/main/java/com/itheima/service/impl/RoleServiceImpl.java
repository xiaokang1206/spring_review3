package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.impl.RoleDaoImpl;
import com.itheima.domain.Role;
import com.itheima.mapper.RoleMapper;
import com.itheima.service.RoleService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    //注入Mapper
    @Autowired
    private RoleMapper roleMapper;






    public List<Role> list()  {



        // List<Role> roleList= roleDao.findAll();
        List<Role> roleList =roleMapper.findAll();

        return roleList;

    }

    @Override
    public void save(Role role) {

        roleDao.save(role);
    }
}
