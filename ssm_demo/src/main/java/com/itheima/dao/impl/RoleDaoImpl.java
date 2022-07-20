package com.itheima.dao.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询所有的角色
    public List<Role> findAll() {

        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));

        return roleList;

    }

    //添加角色
    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert  into sys_role values(?,?,?) ",null,role.getRoleName(),role.getRoleDesc());



    }
//通过用户id查询对应的角色
    @Override
    public List<Role> findRoleByUserID(Long id) {

        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur , sys_role r where ur.roleid=r.id and ur.userid=?", new BeanPropertyRowMapper<Role>(Role.class), id);

        return roles;
    }
}
