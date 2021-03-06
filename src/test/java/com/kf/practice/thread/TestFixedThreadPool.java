package com.kf.practice.thread;

import com.kf.practice.thread.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Thread  thread1= new MyThread();
        Thread  thread2 = new MyThread();
        Thread  thread3 = new MyThread();

        thread3.start();
        thread2.start();
        thread1.start();


        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
    }

}
