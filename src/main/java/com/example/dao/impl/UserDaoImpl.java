package com.example.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.example.dao.UserDao;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
//@Component
@Repository//数据访问层
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll(){
        InputStream in= this.getClass().getClassLoader().getResourceAsStream("user.txt");
        //InputStream in =new FileInputStream(new File("全部地址"));不推荐

        ArrayList<String> lines= IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
    return lines;
    }
}
