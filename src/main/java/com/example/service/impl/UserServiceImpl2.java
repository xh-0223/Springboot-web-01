package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

//@Component//将一个类交给ioc容器保管，只在实现类上不在接口
//@Primary//第①种方法：两个实现类出现两个bean
@Service//业务层相当于Component
public class UserServiceImpl2 implements UserService {
    @Autowired
    private UserDao userDao ;



@Override
    public List<User> findAll(){
        //1.调用dao，获取数据
       List<String> lines=userDao.findAll();
        //2.解析用户信息，封装User对象->list集合
       List<User> userList= lines.stream().map(line-> {
                   String[] parts = line.split(",");
                   Integer id = Integer.parseInt(parts[0]);
                    String username = parts[1];
                   String password = parts[2];
                    String name = parts[3];
                   Integer age = Integer.parseInt(parts[4]);
                   LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    return new User(id+200, username, password, name, age, updateTime);//User对象

               }).collect(Collectors.toList());
       return userList;
    }
}
