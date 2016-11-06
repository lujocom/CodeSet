package com.selfstudy.codeset.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2016年02月25日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class ThreadTest {

    public static void main(String[] args) {

        List<String> target = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            target.add("target -- " + i);
        }

        ExecutorService tpe = Executors.newFixedThreadPool(5);
        ThreadFactory factory ;

        for (int i = 0; i < target.size(); i++) {
            StringTask task = new StringTask(target.get(i));
            tpe.execute(task);
        }

    }
}


class StringTask implements Runnable {

    String task;

    public StringTask() {

    }

    public StringTask(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("执行任务-------" + task );
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(task + " ------ 执行完毕");
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}