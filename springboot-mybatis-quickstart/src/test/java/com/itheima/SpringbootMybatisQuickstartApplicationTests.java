package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindByNameAndPassword() {
        User user = userMapper.findByNameAndPassword("lvbu","123456");
        System.out.println(user);

    }


    public void testDelete(){
        User user =new User();
        userMapper.delete(user);
    }


    public void testInsert(){
        User user =new User(null,"哈哈哈","666888","哈哈哈",18);
        userMapper.insert(user);

    }

    public void testUpdate(){
        User user =new User(1,"货物","4444","是啥",20);
        userMapper.update(user);
    }

}
