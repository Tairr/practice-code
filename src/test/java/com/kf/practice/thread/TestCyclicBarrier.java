package com.kf.practice.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tangjinhui
 * @Description： CyclicBarrier 初始指定了一个容量,当使用barrier.await阻塞的线程数量 = 容量时，所有阻塞的线程都更改为执行(runnable)
 * @date 2018/2/1
 */
public class TestCyclicBarrier {


    private static CyclicBarrier barrier;

    static class ThreadTest1 extends Thread{
        public void run(){
            System.out.println(Thread.currentThread().getName()+" 达到。。。");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 执行完成。。。");
        }

    }


    public static void main(String[] args) {
        barrier = new CyclicBarrier(8);

        for (int i = 0; i < 5; i++) {
            new ThreadTest1().start();
        }


    }

}
