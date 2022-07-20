package com.itheima.mapper;

import com.itheima.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleMapper {
    public List<Role> findAll();
}
