package com.jiangzhongran.JDBC_test.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    /** 
     * ����û� 
     * @param user �û����� 
     */  
    public void insertChild(Child child){  
        // ��ȡ���ݿ�����Connection����  
        Connection conn = DataBaseUtil.getConnection();  
        // �����û���Ϣ��SQL���  
        String sql = "insert into children(name,gentle,age) values(?,?,?)";  
        try {  
            // ��ȡPreparedStatement����  
            PreparedStatement ps = conn.prepareStatement(sql);  
            // ��SQL����ռλ���������ж�̬��ֵ  
            ps.setString(1, child.getName());  
            ps.setString(2, child.getGentle());  
            ps.setInt(3, child.getAge());  
            // ִ�и��²���  
            ps.executeUpdate();  
            // �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ  
            ps.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            // �ر����ݿ�����  
            DataBaseUtil.closeConnection(conn);  
        }  
    }  
    /** 
     * �û���¼ 
     * @param username �û��� 
     * @param password ���� 
     * @return �û����� 
     */  
    public Child login(String username, String password){  
    	Child child = null;  
        // ��ȡ���ݿ�����Connection����  
        Connection conn = DataBaseUtil.getConnection();  
        // �����û�����ѯ�û���Ϣ  
        String sql = "select * from children where username = ?";  
        try {  
            // ��ȡPreparedStatement����  
            PreparedStatement ps = conn.prepareStatement(sql);  
            // ��SQL����ռλ���������ж�̬��ֵ  
            ps.setString(1, username);  
            ps.setString(2, password);  
            // ִ�в�ѯ��ȡ�����  
            ResultSet rs = ps.executeQuery();  
            // �жϽ�����Ƿ���Ч  
            if(rs.next()){  
                // ʵ����һ���û�����  
                child = new Child();  
                // ���û��������Ը�ֵ  
                child.setName(rs.getString("name"));  
                child.setGentle(rs.getString("gentle"));  
                child.setAge(rs.getInt("age"));  
            }  
            // �ͷŴ� ResultSet ��������ݿ�� JDBC ��Դ  
            rs.close();  
            // �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ  
            ps.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            // �ر����ݿ�����  
            DataBaseUtil.closeConnection(conn);  
        }  
        return child;  
    }  
    /** 
     * �ж��û��������ݿ����Ƿ���� 
     * @param username �û��� 
     * @return ����ֵ 
     */  
    public boolean findChild(String name){  
        // ��ȡ���ݿ�����Connection����  
        Connection conn = DataBaseUtil.getConnection();  
        // ����ָ���û�����ѯ�û���Ϣ  
        String sql = "select * from children where name = ?";  
        try {  
            // ��ȡPreparedStatement����  
            PreparedStatement ps = conn.prepareStatement(sql);  
            // ���û��������Ը�ֵ  
            ps.setString(1, name);  
            // ִ�в�ѯ��ȡ�����  
            ResultSet rs = ps.executeQuery();  
            // �жϽ�����Ƿ���Ч  
            if(!rs.next()){  
                // �����Ч��֤�����û�������  
                return true;  
            }  
            // �ͷŴ� ResultSet ��������ݿ�� JDBC ��Դ  
            rs.close();  
            // �ͷŴ� PreparedStatement ��������ݿ�� JDBC ��Դ  
            ps.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }finally{  
            // �ر����ݿ�����  
            DataBaseUtil.closeConnection(conn);  
        }  
        return false;  
    }  

}
