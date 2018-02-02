package com.kf.practice.thread;

import com.kf.practice.entity.Job;
import com.kf.practice.entity.PrintQueue;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class TestSemphore {

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        PrintQueue queue = new PrintQueue();

        for (int i = 0; i < 10 ; i++) {
            threads[i] = new Thread(new Job(queue),"Thread_"+i);
        }

        for (int i = 0; i <10 ; i++) {
            threads[i].start();
        }
    }


}
