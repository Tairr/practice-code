package com.kf.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestBlockingQueue {

    public static void main(String[] args) {


        BlockingQueue queue = new ArrayBlockingQueue(20);

        for (int i = 0; i <30 ; i++) {
            try {
                queue.put(i);
                System.out.println("添加了元素："+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i <10 ; i++) {
            try {
                System.out.println("移除元素："+queue.peek());
                queue.poll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("添加元素结束");

    }

}
