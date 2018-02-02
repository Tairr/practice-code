package com.kf.practice.entity;

import java.util.concurrent.CountDownLatch;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class Conference implements Runnable {

    private final CountDownLatch countDownLatch;

    public Conference(int count) {
        this.countDownLatch = new CountDownLatch(count);
    }

    public void arraive(String name){
        System.out.println(name+" 到达。。。。");
        countDownLatch.countDown();
        System.out.println("还有 "+ countDownLatch.getCount()+" 没有到达。。。");
    }

    @Override
    public void run() {
        System.out.println("准备开会.参会人一共 "+countDownLatch.getCount());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人已到齐，开始开会。。。");
    }
}
