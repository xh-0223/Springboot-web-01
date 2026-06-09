package com.itheima.mapper;


import com.itheima.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
//@Param注解的作用是为接口的方法形参起名字的,官方骨架可以不用加
@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}and password=#{password}")
    public User findByNameAndPassword(@Param("username") String username,@Param("password") String password);
    @Insert("insert into user(id,username,password,name,age) values(#{id},#{username},#{password},#{name},#{age})")
    public void insert(User user);
    @Delete("delete from user where age=20")
    public void delete(User user);
    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age} where id=12")
    public void update(User user);

}
