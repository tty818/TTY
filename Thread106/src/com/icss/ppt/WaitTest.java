package com.icss.ppt;

/**
 * thinking in java p627
 * @author xiaohp
 *
 */
public class WaitTest {
	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		Waiter waiter = new Waiter(restaurant);
		waiter.start();
		Chef chef = new Chef(restaurant,waiter);
		chef.start();
	}
}

class Restaurant {
	public Order order;	
}

class Order{
	private static int i=0;
	private int m_count;
	public Order(){
		m_count = i++;
		if(m_count==10){
			System.out.println("û��ʳ���ˣ�����!");
			System.exit(0);
		}
	}	
}

class Waiter extends Thread
{
	private Restaurant m_restaurant;
	
	public Waiter(Restaurant r){
		m_restaurant = r;		
	}
	
	public void run() {		
		while(m_restaurant.order == null){			
			synchronized(this){
				try {
					System.out.println("Waiter�߳�id=" + Thread.currentThread().getId()+  "  �ȴ���");
					wait();                                     //�ȴ�֪ͨ���ӵ�֪ͨ�������������
					m_restaurant.order = null;
					System.out.println("Waiter�߳�id=" + Thread.currentThread().getId()+  " �յ�֪ͨ��ȡ�߶��� \n");
				} catch (Exception e) {
					// TODO: handle exception
				}			   
			}			
		}						
    }
}

class Chef extends Thread{
	private Restaurant m_restaurant;
	private Waiter m_waiter;
	public Chef(Restaurant restaurant,Waiter waiter){
		m_restaurant = restaurant;
		m_waiter = waiter;				
	}
	public void run(){
		while(true){
			if(m_restaurant.order == null){
				m_restaurant.order = new Order();
				System.out.println("��ʦ�߳�id=" + Thread.currentThread().getId() + "���ӵ��¶���");
				
				synchronized(m_waiter){
					System.out.println("��ʦ�߳�id=" + Thread.currentThread().getId() + "----֪ͨwaiterȡʳ��");
					m_waiter.notify();
				}	
				
				//����Ĵ����Ƶ�sychronized������������
				try {					
					Thread.sleep(1000);					
				} catch (Exception e) {
					// TODO: handle exception
				}				
				
				
				
			}
			
		}				
	}	
}



