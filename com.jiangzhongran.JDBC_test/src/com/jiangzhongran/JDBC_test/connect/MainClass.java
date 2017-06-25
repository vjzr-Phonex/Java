package com.jiangzhongran.JDBC_test.connect;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
//		Child child = new Child();
//		child.setName("Tom");
//		child.setGentle("female");
//		child.setAge(10);
//		userDao.insertChild(child);
		
		boolean result = userDao.findChild("Tom");
		if(result=true){
			System.out.print("Tom exist!");
		}
	}

}
