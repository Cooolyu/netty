package com.gmyl.eparking.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBC {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection conn = null; // 数据库连接
        Statement stmt = null; // 数据库表达式
        ResultSet rs = null; // 结果集
        try {
            /*加载驱动*/
            Class.forName("com.mysql.jdbc.Driver");
            /*连接到数据库*/
            conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/netty?", "root", "root");
            /* 获取表达式*/
            stmt = (Statement) conn.createStatement();
            /*  插入数据*/
            stmt.executeUpdate("insert into clientMsg (message,addTime,type) values ('1',null,'10')");
            /* 执行SQL*/
            rs = stmt.executeQuery("select count(*) as count  from user where name='test' and password='20'");
//            System.out.println(rs);
            /* 查看里面的数据*/
            rs.next();
//            while (rs.next()) {
//                System.out.println("姓名=" + rs.getString("name"));
//                System.out.println("年龄=" + rs.getString("age"));
            	System.out.println(rs.getInt("count"));
//            }        
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
