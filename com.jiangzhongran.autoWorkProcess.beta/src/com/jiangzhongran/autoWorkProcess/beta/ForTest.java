package com.jiangzhongran.autoWorkProcess.beta;

import java.util.ArrayList;
import java.util.List;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a =new ArrayList<String>();
		a.add("1");
		a.add("2");
		for(String temp : a){
			if("1".equals(temp)){
				a.remove(temp);
			}
		}
		System.out.println(a);
	}

}
