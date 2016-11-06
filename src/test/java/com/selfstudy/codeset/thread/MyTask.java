package com.selfstudy.codeset.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;


public class MyTask implements Runnable{
	private int num;
	private ExecutorService executor;
	public MyTask() {
		
	}
	public MyTask(int num,ExecutorService executor) {
		
		this.num = num;
		this.executor = executor;
	}
	@Override
	public void run() {
			System.out.println("线程"+num+"开始.....");
			try {
				Thread.sleep(10000);
				FutureTask<String> futrue = null;
				if(!executor.isShutdown()){
					for (int i = 0; i < 300; i++) {
						futrue = new FutureTask<String>(new MyFuture(i));
						System.out.println("线程"+num+"-"+i+"开始启动");
						executor.execute(futrue);
					}
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.err.println("线程"+num+"全部结束.....");
	}
}
