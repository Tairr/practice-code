package com.kf.practice.thread;

import java.util.concurrent.Phaser;

/**
 * @author tangjinhui
 * @Description： 实现CountDownLatch的功能(注：其实和TestCountDownLatch有较明显的业务区别，CountDownLatch有一个线程阻塞，等待条件达成继续执行，多个线程正常执行并修改条件，
 *                  此例TestPhaser2是 多个线程（通过phaser.awaitAdvance）阻塞，等待phaser.arrive时，再继续执行);
 *
 *                此例似乎和 CyclicBarrier实现的功能更相似
 * @date 2018/2/1
 */
public class TestPhaser2 {

    public static final Phaser phaser = new Phaser(1);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            new Thread(new Task2()).start();
        }

        Thread.sleep(5000);

        phaser.arrive();

    }


    static class Task2 implements Runnable{

        @Override
        public void run() {
            phaser.awaitAdvance(phaser.getPhase()); // countDownLatch.await()
            System.out.println(Thread.currentThread().getName()+" 执行任务");
        }
    }




}
