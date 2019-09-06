package com.icss.ppt;

public class StopThreadTest implements Runnable{
	
	private boolean stopFlag = true;
	
	public void run() {
		int i=0;
		while(stopFlag){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			i++;
			System.out.println(Thread.currentThread().getName()+"----runing i=" + i);
		}
	}
	
	public void stopThread(){
		stopFlag = false;
	}
	
	public static void main(String[] args) {
		
		int index =0;
		StopThreadTest threadStop =  new StopThreadTest();
	    new Thread(threadStop).start(); 		
		while(true){
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			index++;
			System.out.println("*****************" + Thread.currentThread().getName()+"--------"+index);
			if(index == 10){
				threadStop.stopThread();	
				break;
			}			
		}
	}

	
}
