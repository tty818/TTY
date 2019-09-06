package com.icss.ppt;

/**
 * yield: 暂停当前正在执行的线程对象，并执行其他线程
 * @author xiaohp
 *
 */
public class YieldThread implements Runnable{
		private Integer x=0;
				
		@SuppressWarnings("static-access")
		public void run() {				
			for(int i=0;i<50;i++){
		        Thread.currentThread().yield();			//注释此句，其它线程可能无法抢入
				System.out.println("线程ID" + Thread.currentThread().getId()+" :x="+x);
				x++;
			}
			
		}
		
		public static void main(String[] args) {	
			YieldThread yt = new YieldThread();			
			new Thread(yt).start();
			new Thread(yt).start();				
		}
		
	}

