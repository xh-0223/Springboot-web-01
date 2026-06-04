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
@RestController//Responsebody将Controller的返回值直接作为响应体的数据响应+Controller->RestController
public class UserController{
    //ioc控制反转di依赖注入
    //方法一 属性注入  @Autowired//完成依赖注入，从ioc容器中找到bean对象注入依赖di
    //   private UserService userService;
    //方法二 构造器注入
//    private final UserService userService;
//    @Autowired//如果只有一个构造方法可以省略Autowired
//    public UserController(UserService userService){
//        this.userService=userService;
//    }
    //方法三 setter注入
    private UserService userService;
    @Autowired
    public void SetUserService(UserService userService){
        this.userService=userService;
    }
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
