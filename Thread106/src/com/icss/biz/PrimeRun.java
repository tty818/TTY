package com.icss.biz;

public class PrimeRun implements Runnable {
	
private long minPrime;
	
	public PrimeRun(long minPrime) {
		this.minPrime = minPrime;
	}

	@Override
	public void run() {
		for(int i=0;i<minPrime;i++) {
			System.out.println(Thread.currentThread().getId() + "--" + i);
		}
	}
	
	
	
	public synchronized void test() {
		
		synchronized(this) {
			
			
		}		
	}

}
