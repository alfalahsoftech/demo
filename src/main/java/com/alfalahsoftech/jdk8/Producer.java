package com.alfalahsoftech.jdk8;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<Integer> que;
	int i = 0;
	Producer(BlockingQueue<Integer> que ){
		this.que = que;
	}
	
	@Override
	public void run() {
		System.out.println("Entered into Producer" +  que.isEmpty());
		try {
			while(true) {
				
				que.add(i);
				
				System.out.println("Entered into Producer loop " + que.isEmpty());
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
