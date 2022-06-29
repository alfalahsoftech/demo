package com.alfalahsoftech.jdk8;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue<Integer> que;

	Consumer(BlockingQueue<Integer> que) {
		this.que = que;
	}

	@Override
	public void run() {
		System.out.println("Entered into Consumer" + que.isEmpty());
		
			
			try {
				while (true) {
				int i = que.take();
				System.out.println("Consumed value: " + i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	

	}

}
