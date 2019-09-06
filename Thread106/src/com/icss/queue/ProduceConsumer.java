package com.icss.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduceConsumer {

	public static void main(String[] args) {
		BlockingQueue q = new LinkedBlockingQueue();
		Producer p = new Producer(q);
		Producer p2 = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		Consumer c3 = new Consumer(q);
		new Thread(p).start();
		new Thread(p2).start();
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();

	}

}

class Producer implements Runnable {
	private final BlockingQueue queue;

	Producer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				Integer rand = produce();
				queue.put(rand);
				System.out.println(Thread.currentThread().getId() + "´æÈë£º" + rand);
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					
				}
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	private Integer produce() {

		Integer rand = (int) (Math.random() * 1000);

		return rand;

	}
}

class Consumer implements Runnable {
	private final BlockingQueue queue;

	Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				Integer rand = (Integer) queue.take();
				System.out.println(Thread.currentThread().getId() + "È¡³ö£º" + rand);
				try {
					Thread.sleep(70);
				} catch (Exception e) {
					
				}
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
