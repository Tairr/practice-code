package com.kf.practice.thread;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" run MyThread");
        super.run();
    }
}
