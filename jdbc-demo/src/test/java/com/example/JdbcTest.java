package com.example;


import com.example.pojo.User;
import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {

    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取sql语句的执行对象
        Statement statement = connection.createStatement();
        // 4.执行sql
        int i = statement.executeUpdate("UPDATE user set age=25 where id=1");
        //5.释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() {
        String URL = "jdbc:mysql://localhost:3306/web01";
        String USER = "root";
        String PASSWORD = "123456";


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;//封装查询返回结果集
        try {

            // 1. 定义要执行的 SQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);


            // 3. 获取预编译语句对象（防SQL注入，推荐使用）
            String sql = "select id,username,password,name,age from user where username = ? and password = ?";

            // 4. 设置参数：对应 ? 的位置
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "daqiao");
            pstmt.setString(2, "123456");

            // 5. 执行查询
            rs = pstmt.executeQuery();

            // 6. 遍历结果集，封装成 User 对象,rs.next()光标往下一行
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
            }

            // 7. 输出到控制台
            if (user != null) {
                System.out.println("查询到用户信息：");
                System.out.println("ID：" + user.getId());
                System.out.println("用户名：" + user.getUsername());
                System.out.println("密码：" + user.getPassword());
                System.out.println("姓名：" + user.getName());
                System.out.println("年龄：" + user.getAge());
            } else {
                System.out.println("未查询到匹配的用户！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 8. 关闭资源
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}







