package com.icss.ppt;

/**
 * ������4����Ҫ������
 * 1�������������߳�ʹ�õ���Դ��������һ�����ܹ�����һ������һ��ֻ�ܱ�һ��ʹ��
 * 2���̳߳�����Դ���ȴ���һ����Դ�����ſ��ӵ�ͬʱ�ȴ���һֻ����
 * 3����Դ���ܱ���ռ�����������˵Ŀ���
 * 4��ѭ���ȴ���Դ��һֱ���˳�
 *
 */
public class DieLock {
	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[30];	//��Խ��Խ��������	
		ChopStick left,right,first;
		left = new ChopStick();
		right = new ChopStick();
		first = left;		
		for(int i=0;i<philosophers.length-1;i++){
			philosophers[i] = new Philosopher(left,right);
			left = right;                     				//�Է�ʱ��ȡ��ߵĿ��ӣ���ȡ�ұߵ�
			right = new ChopStick();
		}	
		//���һ�˵�����chopstickΪfirst
		philosophers[philosophers.length-1] = new Philosopher(left,first);  		//������
		//philosophers[i] = new Philosopher(first,left);							//��������
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
			sleep(10);                   			//***˼��ʱ��Խ��Խ�����׷�������************
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



