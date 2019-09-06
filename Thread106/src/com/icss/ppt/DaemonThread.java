package com.icss.ppt;
public class DaemonThread {
	/**
	 * 1. 守护线程就是运行在程序后台的线程
	 * 2. 如果虚拟机中只有Daemon thread 在运行，则虚拟机退出
	 * 				
	 * @param args
	 */
    public static void main(String[] args) {    	
    	
        Thread thread = new Thread (	        
	        new Runnable() { 							// 定义一个实现了Runnable接口的匿名类
	            public void run() { 
	                while(true) {
	                	try {
	                		Thread.sleep(500);
	                		System.out.println("-------------in daemon thread");
						} catch (Exception e) {
							// TODO: handle exception
						}	                    
	                }	                
	            }
	        }
           );        
		//修改参数: true为Daemon thread, false为user thead              
        thread.setDaemon(true); 								
        thread.start();			
        
        //如果虚拟机中只有Daemon thread 在运行，则虚拟机退出
        for(int i=0;i<10;i++){        	
	    	try {
				Thread.sleep(500);
				System.out.println("main thread i=" + i);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
        System.out.println("************main thread end*********" );
        
    }  
    
}