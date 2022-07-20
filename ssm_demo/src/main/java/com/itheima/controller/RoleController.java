package com.itheima.controller;

import com.itheima.domain.Role;

import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;


    @RequestMapping("/list")
    public ModelAndView list()  {
        ModelAndView modelAndView=new ModelAndView();

       List<Role> roleList= roleService.list();

       //设置模型对象
        modelAndView.addObject("roleList",roleList);
        //指定视图
        modelAndView.setViewName("role-list");

        return modelAndView;

    }


    @RequestMapping("/save")
    public String save(Role role ){

        roleService.save(role);

         return "redirect:/role/list";//跳到该页面，再次查询数据库显示

    }
}
