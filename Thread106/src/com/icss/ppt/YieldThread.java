package com.icss.ppt;

/**
 * yield: ��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������߳�
 * @author xiaohp
 *
 */
public class YieldThread implements Runnable{
		private Integer x=0;
				
		@SuppressWarnings("static-access")
		public void run() {				
			for(int i=0;i<50;i++){
		        Thread.currentThread().yield();			//ע�ʹ˾䣬�����߳̿����޷�����
				System.out.println("�߳�ID" + Thread.currentThread().getId()+" :x="+x);
				x++;
			}
			
		}
		
		public static void main(String[] args) {	
			YieldThread yt = new YieldThread();			
			new Thread(yt).start();
			new Thread(yt).start();				
		}
		
	}

