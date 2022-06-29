package com.alfalahsoftech.jdk8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterviewTest3 {
	static BlockingQueue<Integer> que = new ArrayBlockingQueue<Integer>(1);

	public static void main(String[] args) {
		Producer p = new Producer(que);
		Consumer c = new Consumer(que);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		
		t2.start();

	}

}
