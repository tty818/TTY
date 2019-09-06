package com.icss.ppt;

/**
 * ÿ���̶߳���һ�����ȼ��������ȼ��̵߳�ִ�������ڵ����ȼ��߳�
 * @author xiaohp
 *
 */
public class PriorityTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Thread.currentThread().getId()+ "--Ȩ�ޣ�" + Thread.currentThread().getPriority());
		
		SecondOut second = new SecondOut();	
		second.setPriority(Thread.MIN_PRIORITY);
		second.start();
		
		Thread third = new Thread(new ThirdOut());
		third.setPriority(Thread.MAX_PRIORITY);
		third.start();		
		
		System.out.println(second.getId() + "--Ȩ��:" + second.getPriority());			
		second.setPriority(Thread.MAX_PRIORITY);
		System.out.println(second.getId() + "---�޸ĺ�Ȩ��:" + second.getPriority());
		
		System.out.println(third.getId() + "--Ȩ��:" + third.getPriority());			
		third.setPriority(Thread.MIN_PRIORITY);
		System.out.println(third.getId() + "---�޸ĺ�Ȩ��:" + third.getPriority());
		
		
		
	}	
}

class SecondOut extends Thread
{
	public void run() {
		int i=0;
		while(true){
			i++;
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}			
			System.out.println("�߳�id=" + Thread.currentThread().getId()+  "  i=" + i +"\n");
		}
    }
}

class ThirdOut implements Runnable{
	public void run() {
		int i=0;
		while(true){
			i++;
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}			
			System.out.println("�߳�id=" + Thread.currentThread().getId()+  "  i=" + i +"\n");
		}
    }
}
