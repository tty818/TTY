package com.icss.ppt;
public class DaemonThread {
	/**
	 * 1. �ػ��߳̾��������ڳ����̨���߳�
	 * 2. ����������ֻ��Daemon thread �����У���������˳�
	 * 				
	 * @param args
	 */
    public static void main(String[] args) {    	
    	
        Thread thread = new Thread (	        
	        new Runnable() { 							// ����һ��ʵ����Runnable�ӿڵ�������
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
		//�޸Ĳ���: trueΪDaemon thread, falseΪuser thead              
        thread.setDaemon(true); 								
        thread.start();			
        
        //����������ֻ��Daemon thread �����У���������˳�
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