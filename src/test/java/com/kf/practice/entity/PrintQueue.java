package com.kf.practice.entity;

import java.util.concurrent.Semaphore;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(Object document){
        try {
            semaphore.acquire();
            long duration = (long)(Math.random()*10);
            System.out.println(Thread.currentThread().getName()+" PrintQueue: printing a job during "+duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

}
