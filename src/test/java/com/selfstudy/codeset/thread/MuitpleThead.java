package com.selfstudy.codeset.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MuitpleThead {
	
	
	private   List<String> values = new ArrayList<String>();
	
	public void putValues(String value){
		
		values.add(value);
		
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(8);
		ExecutorService executor1 = Executors.newFixedThreadPool(8);
		MyTask myTask = null;
		for(int i=0;i<300;i++){
             myTask = new MyTask(i,executor1);
            executor.execute(myTask);
        }
        executor.shutdown();
        executor1.shutdown();
        long entTime = System.currentTimeMillis();
        System.out.println("总共执行时间:"+(entTime-startTime));
    }
	
	
}


