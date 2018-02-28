package com.kf.practice.justTest;

import com.kf.practice.justTest.model.LoggingWidget;
import com.kf.practice.justTest.model.Widget;

/**
 * @author tangjinhui
 * @Description：如何用一句话介绍synchronize的内涵  https://zhuanlan.zhihu.com/p/33159374
 * @Mark: Java中每一个对象都有一个与之关联的锁，称为内置锁;内置锁的可重入性（Reentrancy）
 *        当我们使用synchronize修饰非静态方法时，用的是调用该方法的实例的内置锁，也就是this;
          当我们使用synchronize修饰静态方法时，用的是调用该方法的所在的类对象的内置锁;
 * @date 2018/2/23
 */
public class ThreadInLock {
    public static void main(String[] args) {
        Widget widget = new LoggingWidget();
        Thread thread = new Thread(()->{
            widget.doSomething();
        });

        Thread thread1 = new Thread(()->{
            widget.doSomething();
        });

        thread.start();
        thread1.start();
    }
}
