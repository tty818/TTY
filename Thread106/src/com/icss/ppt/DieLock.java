package com.icss.ppt;

/**
 * 死锁的4个必要条件：
 * 1、互斥条件：线程使用的资源中至少有一个不能共享，如一根筷子一次只能被一人使用
 * 2、线程持有资源并等待另一个资源：拿着筷子的同时等待另一只筷子
 * 3、资源不能被抢占：不能抢别人的筷子
 * 4、循环等待资源：一直不退出
 *
 */
public class DieLock {
	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[30];	//人越少越容易死锁	
		ChopStick left,right,first;
		left = new ChopStick();
		right = new ChopStick();
		first = left;		
		for(int i=0;i<philosophers.length-1;i++){
			philosophers[i] = new Philosopher(left,right);
			left = right;                     				//吃饭时先取左边的筷子，再取右边的
			right = new ChopStick();
		}	
		//最后一人的右手chopstick为first
		philosophers[philosophers.length-1] = new Philosopher(left,first);  		//会死锁
		//philosophers[i] = new Philosopher(first,left);							//不会死锁
	}
}

class ChopStick{
	private static int counter = 0;
	private int number = counter++;
	public String toString(){	
		return "ChopStick" + number;
	}
}

class Philosopher extends Thread{
	
	private static int counter = 0;
	private int number = counter++;
    private ChopStick leftChopstick;	
    private ChopStick rightChopstick;
    
    
    public Philosopher(ChopStick left,ChopStick right){
    	leftChopstick = left;
    	rightChopstick = right;
    	start();
    }
    
    public void think(){
    	
		try {			
			sleep(10);                   			//***思考时间越长越不容易发生死锁************
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
    }
    
    public  void  eat(){
    	synchronized(leftChopstick){
    		System.out.println(leftChopstick + " waiting for  " + rightChopstick);
    		
    		synchronized(rightChopstick){
    			System.out.println(this + " now eating ");
    		}    		
    	}    	
    }
    
    public String toString(){
		return "Philosopher" + number;
	}
    
    public void run(){
    	while(true){
    		think();
    		eat();
    	}
    }
	
}



