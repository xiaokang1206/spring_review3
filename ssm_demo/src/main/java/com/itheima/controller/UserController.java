package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(){
         List<User> userList= userService.list();

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("userList" ,userList);

        modelAndView.setViewName("user-list");
        return modelAndView;

    }


    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        //获取Role复选框内容
        List<Role> roleList = roleService.list();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");

        return modelAndView;

    }

    @RequestMapping("/save")
    public String save(User user,long[] roleIds){

                  userService.save(user,roleIds);

        return "redirect:/user/list";

    }

    @RequestMapping("/del/{userId}")
    public String del( @PathVariable("userId") Long userId){

             userService.del(userId);

        return "redirect:/user/list";

    }

    @RequestMapping("/login")
    public String login(String username , String password, HttpSession session){
      User user=  userService.login(username,password);
      if (user!=null){
          //账户密码正确,跳转业务请求的页面,将user存储session域
             session.setAttribute("user",user);
          return "redirect:/index.jsp";

      }
          //账户密码输入有误,登录失败

        return "redirect:/login.jsp";

    }

}
