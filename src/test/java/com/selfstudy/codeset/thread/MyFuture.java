package com.selfstudy.codeset.thread;

import java.util.concurrent.Callable;

public class MyFuture implements Callable<String>{
	
	
	private  int i;
	public MyFuture(int i) {
		this.i = i;
	}
	@Override
	public String call() throws Exception {
		String abc ="第"+i+"个线程执行完成";
		return abc;
	}

}
