package com.icss.ui;

import com.icss.biz.PrimeThread;

public class TestPrime {
	public static void main(String[] args) {
		System.out.println("���̣߳�" + Thread.currentThread().getId() );
		PrimeThread prime = new PrimeThread(100);
		//prime.run();        //ֱ�ӵ���run()�����������������߳�
		
		prime.start();        //������һ�����̣߳������߳�������run()����
		
	}

}
