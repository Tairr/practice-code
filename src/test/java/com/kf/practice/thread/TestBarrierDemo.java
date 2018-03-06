package com.kf.practice.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/1
 */
public class TestBarrierDemo {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrierDemo demo = new CyclicBarrierDemo(10);

        for (int i = 1; i < 101 ; i++) {
            demo.doWork();
            if(i%10 ==0)
                TimeUnit.MILLISECONDS.sleep(10000);
        }
        
    }
    
}
