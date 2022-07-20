package com.itheima.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
               Target target=new Target();//目标对象
               Advice advice=new Advice();//增强对象

       TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            //调用代理对象的任何方法，实际执行的是invoke方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                advice.before();
                Object invoke = method.invoke(target, args);//执行目标方法
                advice.afterReturning();
                return invoke;





            }
        });
       //调用代理对象的方法
        proxy.save();
        //target.save();
    }
}
