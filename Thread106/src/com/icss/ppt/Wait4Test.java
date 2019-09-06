package com.icss.ppt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Wait4Test {

	public static void main(String[] args) {

		ReentrantLock locker = new ReentrantLock();
		Condition con1 = locker.newCondition();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getId() + "--" + i);
					if (i == 20) {
						try {
							locker.lock();
							System.out.println(Thread.currentThread().getId() + "等待通知..");
							con1.await(); // 使用监视器，休眠当前线程（同时释放锁）							
						} catch (Exception e) {
						} finally {
							locker.unlock();
						}
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}

			}
		}).start();

		for (int i = 0; i < 100; i++) {
			System.out.println("主：" + Thread.currentThread().getId() + "--" + i);
			if (i == 80) {
				try {
					locker.lock();
					System.out.println(Thread.currentThread().getId() + "发出唤醒通知..");
					con1.signal();
				} catch (Exception e) {
				} finally {
					locker.unlock();
				}
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
			}

		}

	}

}
