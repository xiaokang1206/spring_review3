package com.itheima.controller.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.CredentialException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    @Override
    //在目标方法执行前，执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle...");
        String param = request.getParameter("param");

        if("yes".equals(param)){
            return true;//返回true代表放行}
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;

        }

    }

    @Override
    //在目标方法执行之后，视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       modelAndView.addObject("name","heima");

        System.out.println("postHandle...");

    }

    @Override
    //在流程都执行完毕后,执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion...");
    }
}
