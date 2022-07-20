package com.itheima.service;

import com.itheima.domain.Role;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

public interface RoleService {
    public List<Role> list() ;

    void save(Role role);
}
