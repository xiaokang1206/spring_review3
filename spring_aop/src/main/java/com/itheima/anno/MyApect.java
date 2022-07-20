package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect//标注当前myaspect是一个切面类
public class MyApect {


    @Before("execution(* com.itheima.anno.*.*(..))")
    public void before(){

        System.out.println("前置增强...");
    }

    public void afterRetruning(){

        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint 切点对象
    @Around("execution(* com.itheima.anno.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("环绕前增强...");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后增强...");
        return proceed;

    }

    public void afterThrowing(){

        System.out.println("异常抛出增强....");
    }
       @After("pointcut()")//引用切点表达式
    public void after(){
        System.out.println("最终增强...");
    }

    //定义切点表达式
    @Pointcut("execution(* com.itheima.anno.*.*(..))")
    public  void pointcut(){

    }
}
