package com.codinko.threads.highlevelconcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Scenario of ThreadPool: ThreadPool = Serviceprovider(size) + Tasks
 * 
 * Serviceprovider -> a list of threads [thread pool]
 * 
 * Task -> the task that need to be processed by a thread. The tasks may be in a
 * queue.
 * 
 */
public class VagueDemoThreadPool {

	private BlockingQueue<Object> taskQueue = null;
	private List<PoolThread> threadlist = null;

	// maxNoOfTasks need not be specified on creation of pool
	public VagueDemoThreadPool(int noOfThreads, int maxNoOfTasks) {

		threadlist = new ArrayList<PoolThread>(noOfThreads + 1);
		taskQueue = new ArrayBlockingQueue<Object>(maxNoOfTasks);

		MyService.setTaskQueue(taskQueue);

		for (int i = 0; i < noOfThreads; i++) {
			threadlist.add(new PoolThread(taskQueue));
		}
		for (PoolThread thread : threadlist) {
			thread.start();
		}
		// the threads should run when ever new tasks are available ! ?
	}

	// this.taskQueue.add(task);

}

class PoolThread extends Thread {

	private BlockingQueue<Object> taskQueue = null;

	public PoolThread(BlockingQueue<Object> queue) {
		taskQueue = queue;
	}

	public void run() {
		try {
			// Wait for a task to become available on the taskQueue
			Object obj = (Object) taskQueue.take();
			// obj.doSomething();
		} catch (Exception e) {
			// log or otherwise report exception,
			// but keep pool thread alive.
		}
	}

}

class MyService {

	private static BlockingQueue<Object> taskkQueue;

	public static void setTaskQueue(BlockingQueue<Object> taskQueue) {
		taskkQueue = taskQueue;
	}

	void sendMessage(Object message) {
		if (taskkQueue != null)
			try {
				taskkQueue.put(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
}
