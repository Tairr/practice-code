package com.kf.practice.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestBlockingDeque {

    public static void main(String[] args) throws InterruptedException {

        BlockingDeque deque = new LinkedBlockingDeque(20);

        for (int i = 0; i < 30; i++) {
            deque.putFirst(i);
            System.out.println("阻塞栈添加了："+i);
        }

        System.out.println("操作完成");
    }

}
