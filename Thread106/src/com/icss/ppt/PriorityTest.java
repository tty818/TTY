package com.icss.ppt;

/**
 * 每个线程都有一个优先级，高优先级线程的执行优先于低优先级线程
 * @author xiaohp
 *
 */
public class PriorityTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Thread.currentThread().getId()+ "--权限：" + Thread.currentThread().getPriority());
		
		SecondOut second = new SecondOut();	
		second.setPriority(Thread.MIN_PRIORITY);
		second.start();
		
		Thread third = new Thread(new ThirdOut());
		third.setPriority(Thread.MAX_PRIORITY);
		third.start();		
		
		System.out.println(second.getId() + "--权限:" + second.getPriority());			
		second.setPriority(Thread.MAX_PRIORITY);
		System.out.println(second.getId() + "---修改后权限:" + second.getPriority());
		
		System.out.println(third.getId() + "--权限:" + third.getPriority());			
		third.setPriority(Thread.MIN_PRIORITY);
		System.out.println(third.getId() + "---修改后权限:" + third.getPriority());
		
		
		
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
			System.out.println("线程id=" + Thread.currentThread().getId()+  "  i=" + i +"\n");
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
			System.out.println("线程id=" + Thread.currentThread().getId()+  "  i=" + i +"\n");
		}
    }
}
