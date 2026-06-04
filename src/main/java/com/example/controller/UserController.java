package com.example.controller;

import cn.hutool.core.io.IoUtil;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//用户信息
@RestController
public class UserController{

    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    public List<User> list() {
            //1.调用service，获取数据

            List<User> userList= userService.findAll();
            //2.返回数据Json


        return userList;



       //1.读取用户数据
//       InputStream in= this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        //InputStream in =new FileInputStream(new File("全部地址"));不推荐
//        ArrayList<String> lines=IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
//        //2.解析用户信息，封装User对象->list集合
//       List<User> userList= lines.stream().map(line-> {
//                    String[] parts = line.split(",");
//                    Integer id = Integer.parseInt(parts[0]);
//                    String username = parts[1];
//                    String password = parts[2];
//                    String name = parts[3];
//                    Integer age = Integer.parseInt(parts[4]);
//                    LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//                    return new User(id, username, password, name, age, updateTime);//User对象
//
//                }).collect(Collectors.toList());
//        //3.返回数据json
//            return userList;



    }
}
