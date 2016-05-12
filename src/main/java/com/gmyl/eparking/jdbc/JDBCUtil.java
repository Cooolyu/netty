package com.gmyl.eparking.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCUtil {
	
    private Connection conn = null; // 数据库连接
    private Statement stmt = null; // 数据库表达式
    private ResultSet rs = null; // 结果集
    
    //查询
    public ResultSet selectSql (String sql){
        try {
            /*加载驱动*/
            Class.forName("com.mysql.jdbc.Driver");
            /*连接到数据库*/
            conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/netty?", "root", "root");
            /* 获取表达式*/
            stmt = (Statement) conn.createStatement();
            return stmt.executeQuery(sql);
        }catch (Exception e){
        		System.out.println(e.getMessage());
        		return null;
        }
    }
    
    //添加
    public void addSql(String sql){
		try {
			/* 加载驱动 */
			Class.forName("com.mysql.jdbc.Driver");
			/* 连接到数据库 */
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netty?", "root", "root");
			/* 获取表达式 */
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    }
    
    //修改
    public int updateSql(String sql){
		try {
			/* 加载驱动 */
			Class.forName("com.mysql.jdbc.Driver");
			/* 连接到数据库 */
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/netty?", "root", "root");
			/* 获取表达式 */
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
    }

}
