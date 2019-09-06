package com.icss.ppt;

/**
 * thinking in java p597
 */
public class JoinTest{		
		
	public static void main(String[] args) {
		Sleeper sleeper = new Sleeper();
		sleeper.setName("sleeper");
		sleeper.start();
		
		Joiner joiner = new Joiner(sleeper);
		joiner.setName("joined");
		joiner.start();								
	}
}
	

class Sleeper extends Thread
{
	public void run() {
		
		System.out.println("Sleeper�߳�id=" + Thread.currentThread().getName() +  "   start run");
		try {
			for(int i=0;i<50;i++){
				Thread.sleep(100);
				System.out.println("�߳�" + Thread.currentThread().getName() + "---i=" + i);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}					
		System.out.println("Sleeper�߳�id=" + Thread.currentThread().getName() +  "   end");		
    }
}


class Joiner extends Thread
{
	private Sleeper m_sleeper;
	public Joiner(Sleeper sleeper ){
		m_sleeper = sleeper;
	}
	public void run() {		
		System.out.println("�߳�id=" + Thread.currentThread().getName()+  "  start run");
		
		try {						
			for(int i=0;i<50;i++){
				Thread.sleep(100);				
				System.out.println("�߳�" + Thread.currentThread().getName() + "---k=" + i);				
				if(i==5){
					System.out.println("sleeper׼�����뵽��ǰ�߳��߳�" + Thread.currentThread().getName());
					m_sleeper.join();			//sleeper���뵽��ǰ�߳�,��ǰ�̱߳��������ȴ�sleeper���н���������̲߳ż�������
				}					
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}			
		System.out.println("�߳�id=" + Thread.currentThread().getName()+  "  end");		
    }
}

