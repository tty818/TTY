package com.icss.ui;

import com.icss.biz.PrimeRun;

public class TestRun {
	
	public static void main(String[] args) {
		System.out.println("Ö÷Ïß³Ì£º" + Thread.currentThread().getId() );
		PrimeRun prime = new PrimeRun(100);
		new Thread(prime).start();
	}

}
