package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //运行时自动为接口创建实现类对象，并且自动的将该实现类对象存入IOC容器 -bean
public interface UserMapper {
@Select("select * from user")
    public List<User> findAll();
@Delete("delete from user where id=  #{id}")
//public void deleteByID(Integer id);
    public Integer deleteById(Integer id);

}
