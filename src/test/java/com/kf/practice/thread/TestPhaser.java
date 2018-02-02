package com.kf.practice.thread;

import java.util.concurrent.Phaser;

/**
 * @author tangjinhui
 * @Description Phaser初始容量后，每个执行phaser.arriveAndAwaitAdvance()的线程进入阻塞,当阻塞的线程数量=容量时,所有阻塞的线程继续执行
 *              该示例实现的功能类似 CyclicBarrier
 * @date 2018/2/1
 */
public class TestPhaser {


    private static final Phaser phaser= new Phaser(4);

    public static void main(String[] args) {

        Task1 task1= new Task1();

        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();
        new Thread(task1).start();

    }


    static class Task1 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" 执行任务完成，等待其他任务");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName()+" 继续执行");

        }
    }

}
