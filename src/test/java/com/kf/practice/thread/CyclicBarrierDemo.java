package com.kf.practice.thread;

import org.junit.internal.runners.statements.RunAfters;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/1
 */
public class CyclicBarrierDemo {

    final CyclicBarrier barrier ;
    final int MAX_TASK;

    public CyclicBarrierDemo(int MAX_TASK) {
        barrier = new CyclicBarrier(MAX_TASK +1);
        this.MAX_TASK = MAX_TASK;
    }

    public void doWork(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = barrier.await();
                    System.out.println("执行任务"+count+"/%");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
