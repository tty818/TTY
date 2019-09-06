package com.icss.biz;

public class PrimeThread extends Thread {
	
	private long minPrime;
	
	public PrimeThread(long minPrime) {
		this.minPrime = minPrime;
	}
	
	public void run() {
		
		for(int i=0;i<minPrime;i++) {
			System.out.println(Thread.currentThread().getId() + "--" + i);
		}
		
	}

}
