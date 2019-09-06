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
			System.out.println("没有食物了，结束!");
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
					System.out.println("Waiter线程id=" + Thread.currentThread().getId()+  "  等待中");
					wait();                                     //等待通知，接到通知后才能向下运行
					m_restaurant.order = null;
					System.out.println("Waiter线程id=" + Thread.currentThread().getId()+  " 收到通知，取走订单 \n");
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
				System.out.println("厨师线程id=" + Thread.currentThread().getId() + "，接到新订单");
				
				synchronized(m_waiter){
					System.out.println("厨师线程id=" + Thread.currentThread().getId() + "----通知waiter取食物");
					m_waiter.notify();
				}	
				
				//下面的代码移到sychronized上面会出现死锁
				try {					
					Thread.sleep(1000);					
				} catch (Exception e) {
					// TODO: handle exception
				}				
				
				
				
			}
			
		}				
	}	
}



