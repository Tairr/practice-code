package com.kf.practice.thread;

import java.util.concurrent.*;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor service = new ScheduledThreadPoolExecutor(1);

        service.scheduleAtFixedRate(()->{

            System.out.println(Thread.currentThread().getName()+" Test ScheduledThreadPoolExecutor 2000");

        },1000,2000, TimeUnit.MICROSECONDS);


        service.scheduleAtFixedRate(()->{

            System.out.println(Thread.currentThread().getName()+" Test ScheduledThreadPoolExecutor 5000");

        },1000,5000, TimeUnit.MICROSECONDS);


    }
}
