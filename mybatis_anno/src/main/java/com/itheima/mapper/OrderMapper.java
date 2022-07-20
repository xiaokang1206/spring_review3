package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders where uid=#{uid}")
    public List<Order> findByUid(int uid);

//多表查询一对一
   @Select("select *  from orders  ")
   @Results({
           @Result(column = "id",property = "id"),
           @Result(column = "ordertime",property = "ordertime"),
           @Result(column = "total",property = "total"),
           @Result(
                   property = "user",//需要封装的属性名称
                   column = "uid",//根据那个字段去查询user表数据
                   javaType = User.class,
                   //select属性 代表查询那个接口的方法获得数据
                 one =  @One(select = "com.itheima.mapper.UserMapper.findById")

           )

   })
    public List<Order> findAll();




   /* @Select("select * ,o.id oid from orders o ,user u where o.uid = u.id ")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password")*/
}
