package com.icss.ppt;

public class WaitTest3 {
	
	public static void main(String[] args) {
		Object obj = new Object();   //同一个object对象，可以加很多监视器
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
                    System.out.println(Thread.currentThread().getId() + "--" + i);  			
                    if(i==20) {                    	
                    	try {
                    		synchronized (obj) {
                      		    System.out.println(Thread.currentThread().getId() + "等待通知..");
                    			obj.wait();	   //给object对象加监视器，使当前线程进入wait blocked状态
							}                    		
    					} catch (Exception e) {
    					}
                    }
                    try {
                       Thread.sleep(100);						
					} catch (Exception e) {
					}
					
				}
				
			}
		}).start();	
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
                    System.out.println(Thread.currentThread().getId() + "--" + i);  			
                    if(i==50) {                    	
                    	try {
                    		synchronized (obj) {
                      		    System.out.println(Thread.currentThread().getId() + "等待通知..");
                    			obj.wait();	  //给object对象再次加监视器，使当前线程进入wait blocked状态
							}                    		
    					} catch (Exception e) {
    					}
                    }
                    try {
                       Thread.sleep(100);						
					} catch (Exception e) {
					}
					
				}
				
			}
		}).start();	
		
		
		for(int i=0;i<100;i++) {
            System.out.println("主：" + Thread.currentThread().getId() + "--" + i);  			
            if(i==80) {                    	
            	try {
            		synchronized (obj) {
            		  System.out.println(Thread.currentThread().getId() + "发出唤醒通知..");
            		  obj.notifyAll();    //唤醒全部监视器线程   		  
					}                    		
				} catch (Exception e) {
				}
            }
            try {
                Thread.sleep(100);				
			} catch (Exception e) {
			}
			
		}
		
	}

}
