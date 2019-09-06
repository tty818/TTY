package com.icss.ui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
	
	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		//用三个线程，执行100个任务
		for(int i=0;i<100;i++) {			
			pool.submit(new Runnable() {				
				@Override
				public void run() {
					int rand = (int)(Math.random()*100);
					System.out.println(Thread.currentThread().getId() + "--" + rand);	
					try {
                      Thread.sleep(100);						
					} catch (Exception e) {
					}
				}
			});
		}
		pool.shutdown();
	}

}
