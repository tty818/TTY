package com.icss.ppt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Wait5Test {
   public static void main(String[] args) {

		ReentrantLock locker = new ReentrantLock();
		Condition con1 = locker.newCondition();
		Condition con2 = locker.newCondition();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getId() + "--" + i);
					if (i == 20) {
						try {
							locker.lock();
							System.out.println(Thread.currentThread().getId() + "�ȴ�֪ͨ..");
							con1.await(); // ʹ�ü����������ߵ�ǰ�̣߳�ͬʱ�ͷ�����							
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
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getId() + "--" + i);
					if (i == 50) {
						try {
							locker.lock();
							System.out.println(Thread.currentThread().getId() + "�ȴ�֪ͨ..");
							con2.await(); // ʹ�ü����������ߵ�ǰ�̣߳�ͬʱ�ͷ�����							
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
			System.out.println("����" + Thread.currentThread().getId() + "--" + i);
			if (i == 80) {
				try {
					locker.lock();
					System.out.println(Thread.currentThread().getId() + "��������֪ͨ..");
					//con1.signal();
					con2.signal();
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
