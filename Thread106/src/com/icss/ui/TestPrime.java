package com.icss.ui;

import com.icss.biz.PrimeThread;

public class TestPrime {
	public static void main(String[] args) {
		System.out.println("主线程：" + Thread.currentThread().getId() );
		PrimeThread prime = new PrimeThread(100);
		//prime.run();        //直接调用run()方法，不能启动新线程
		
		prime.start();        //启动了一个新线程，在新线程中运行run()方法
		
	}

}
