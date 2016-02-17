package com.learn.one;

public class easy {

	public easy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
//		System.out.println(test());
		fib();
	}
	
	public static int test(){
		int a =1;
		try{
			a = 2;
			throw new Exception();
		}catch(Exception e){
			a = 3;
			System.out.println("catch a is " +a);
			return a*a;
		}finally{
			System.out.println("finally a is "+a );
			a = 4;
			System.out.println("finally2 a is "+a);
			
		}
	}
	
	@SuppressWarnings("static-access")
	public static void fib(){
		System.out.println("计算斐波那契数列：");
		long i=0,j=1;
		long tmp = 0;
		while(true){
			tmp = i + j;
			i=j;
			j=tmp;
			System.out.print(tmp+" ");
			try{
				Thread.currentThread().sleep(10);
			}catch(Exception e){
				
			}
		}
	}
}
