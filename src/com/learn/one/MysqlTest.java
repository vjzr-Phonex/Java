package com.learn.one;

import java.sql.*;

public class MysqlTest {

	static final String	USER = "root";
	static final String PASSWORD = "1111";
	
	public MysqlTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String url = null;
		String user = null;
		String sql = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载Mysql驱动失败");
			e.printStackTrace();
		}
		
		try {
			url = "jdbc:mysql://localhost/jzr?user="+USER+"&"+PASSWORD;
			conn = DriverManager.getConnection(url,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql connect fail!");
			e.printStackTrace();
		}
		
		try {
			statement = conn.createStatement();
			sql = "select *from t_test";
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()){
				System.out.println(resultSet.getInt("num")+" "+resultSet.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
