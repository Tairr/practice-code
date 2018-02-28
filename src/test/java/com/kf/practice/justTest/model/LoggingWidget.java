package com.kf.practice.justTest.model;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/23
 */
public class LoggingWidget extends Widget {

    public synchronized void doSomething(){
        System.out.println(toString()+": calling doSomething");
        super.doSomething();
    }
}
