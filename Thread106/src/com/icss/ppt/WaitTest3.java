package com.icss.ppt;

public class WaitTest3 {
	
	public static void main(String[] args) {
		Object obj = new Object();   //ͬһ��object���󣬿��ԼӺܶ������
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
                    System.out.println(Thread.currentThread().getId() + "--" + i);  			
                    if(i==20) {                    	
                    	try {
                    		synchronized (obj) {
                      		    System.out.println(Thread.currentThread().getId() + "�ȴ�֪ͨ..");
                    			obj.wait();	   //��object����Ӽ�������ʹ��ǰ�߳̽���wait blocked״̬
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
                      		    System.out.println(Thread.currentThread().getId() + "�ȴ�֪ͨ..");
                    			obj.wait();	  //��object�����ٴμӼ�������ʹ��ǰ�߳̽���wait blocked״̬
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
            System.out.println("����" + Thread.currentThread().getId() + "--" + i);  			
            if(i==80) {                    	
            	try {
            		synchronized (obj) {
            		  System.out.println(Thread.currentThread().getId() + "��������֪ͨ..");
            		  obj.notifyAll();    //����ȫ���������߳�   		  
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
