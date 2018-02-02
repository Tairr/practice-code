package com.kf.practice.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class Job implements Runnable {


    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" going to print");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName()+" the document has been printed");
    }
}
