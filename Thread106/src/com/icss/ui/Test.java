package com.icss.ui;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("���̣߳�" + Thread.currentThread().getId() );
		
		//������
		new Thread(new Runnable() {			
			@Override
			public void run() {				
				for(int i=0;i<100;i++) {
					System.out.println(Thread.currentThread().getId() + "--" + i);
					try {
                        Thread.sleep(200);						
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
					try {
                        Thread.sleep(200);						
					} catch (Exception e) {
					}
				}				
			}
		}).start();
	}

}
