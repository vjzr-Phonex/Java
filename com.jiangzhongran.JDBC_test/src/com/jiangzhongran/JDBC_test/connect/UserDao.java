package com.jiangzhongran.JDBC_test.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /** 
     * 添加用户 
     * @param user 用户对象 
     */  
    public void insertChild(Child child){  
        // 获取数据库连接Connection对象  
        Connection conn = DataBaseUtil.getConnection();  
        // 插入用户信息的SQL语句  
        String sql = "insert into children(name,gentle,age) values(?,?,?)";  
        try {  
            // 获取PreparedStatement对象  
            PreparedStatement ps = conn.prepareStatement(sql);  
            // 对SQL语句的占位符参数进行动态赋值  
            ps.setString(1, child.getName());  
            ps.setString(2, child.getGentle());  
            ps.setInt(3, child.getAge());  
            // 执行更新操作  
            ps.executeUpdate();  
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源  
            ps.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            // 关闭数据库连接  
            DataBaseUtil.closeConnection(conn);  
        }  
    }  
    /** 
     * 用户登录 
     * @param username 用户名 
     * @param password 密码 
     * @return 用户对象 
     */  
    public Child login(String username, String password){  
    	Child child = null;  
        // 获取数据库连接Connection对象  
        Connection conn = DataBaseUtil.getConnection();  
        // 根据用户名查询用户信息  
        String sql = "select * from children where username = ?";  
        try {  
            // 获取PreparedStatement对象  
            PreparedStatement ps = conn.prepareStatement(sql);  
            // 对SQL语句的占位符参数进行动态赋值  
            ps.setString(1, username);  
            ps.setString(2, password);  
            // 执行查询获取结果集  
            ResultSet rs = ps.executeQuery();  
            // 判断结果集是否有效  
            if(rs.next()){  
                // 实例化一个用户对象  
                child = new Child();  
                // 对用户对象属性赋值  
                child.setName(rs.getString("name"));  
                child.setGentle(rs.getString("gentle"));  
                child.setAge(rs.getInt("age"));  
            }  
            // 释放此 ResultSet 对象的数据库和 JDBC 资源  
            rs.close();  
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源  
            ps.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            // 关闭数据库连接  
            DataBaseUtil.closeConnection(conn);  
        }  
        return child;  
    }  
    /** 
     * 判断用户名在数据库中是否存在 
     * @param username 用户名 
     * @return 布尔值 
     */  
    public boolean findChild(String name){  
        // 获取数据库连接Connection对象  
        Connection conn = DataBaseUtil.getConnection();  
        // 根据指定用户名查询用户信息  
        String sql = "select * from children where name = ?";  
        try {  
            // 获取PreparedStatement对象  
            PreparedStatement ps = conn.prepareStatement(sql);  
            // 对用户对象属性赋值  
            ps.setString(1, name);  
            // 执行查询获取结果集  
            ResultSet rs = ps.executeQuery();  
            // 判断结果集是否有效  
            if(!rs.next()){  
                // 如果无效则证明此用户名可用  
                return true;  
            }  
            // 释放此 ResultSet 对象的数据库和 JDBC 资源  
            rs.close();  
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源  
            ps.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            // 关闭数据库连接  
            DataBaseUtil.closeConnection(conn);  
        }  
        return false;  
    }  

}
