package com.kf.practice.thread;

import com.kf.practice.entity.Conference;
import com.kf.practice.entity.Participter;

/**
 * @author tangjinhui
 * @Description： CountDownLatch, 是多个线程修改(countDownLatch.countdown)了公共的计数器
 *                当计数器=0时, 因为公共计数而阻塞(countDownLatch.await)的线程将继续执行
 * @date 2018/2/1
 */
public class TestCountDownLatch {

    public static void main(String[] args) {

        Conference conference = new Conference(3);

        new Thread(conference).start();

        Participter p1 = new Participter("张三",conference);
        Participter p2 = new Participter("李四",conference);
        Participter p3 = new Participter("王五",conference);
        Participter p4 = new Participter("呵呵",conference);

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();

    }

}
