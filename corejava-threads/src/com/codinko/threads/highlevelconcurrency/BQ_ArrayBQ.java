package com.codinko.threads.highlevelconcurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BQ_ArrayBQ {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<String> queuee = new ArrayBlockingQueue<String>(2);

		new Consumer(queuee).start();

		queuee.put("task1");
		System.out.println(">>>>>> task1 is inserted to queue");
		Thread.sleep(2000);
		queuee.put("task2");
		System.out.println(">>>>>> task2 is inserted to queue");
		Thread.sleep(2000);
		queuee.put("task3");
		System.out.println(">>>>>> task3 is inserted to queue");
		Thread.sleep(2000);
		queuee.put("task4");
		System.out.println(">>>>>> task4 is inserted to queue");
	}
}

class Consumer extends Thread {

	BlockingQueue<String> queue;

	Consumer(BlockingQueue<String> queuee) {
		this.queue = queuee;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("About to take a task from queue");
				String task = queue.take();
				System.out.println(":::: Took a task from queue : " + task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//@formatter:off
/**
*
*OUTPUT:
*
*>>>>>> task1 is inserted to queue
About to take a task from queue
:::: Took a task from queue : task1
About to take a task from queue
>>>>>> task2 is inserted to queue
:::: Took a task from queue : task2
About to take a task from queue
>>>>>> task3 is inserted to queue
:::: Took a task from queue : task3
About to take a task from queue
>>>>>> task4 is inserted to queue
:::: Took a task from queue : task4
About to take a task from queue

... and the program never ends, because Thread gets blocked on queue.take(); when queue becomes empty
*
*/
}


