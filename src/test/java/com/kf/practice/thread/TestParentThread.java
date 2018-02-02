package com.kf.practice.thread;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/2
 */
public class TestParentThread {


    public static void main(String[] args) {

        TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

        threadLocal.set("hh");

        System.out.println("run in "+Thread.currentThread().getName());


        new Thread(()->{
            System.out.println(threadLocal.get()+" run in "+Thread.currentThread().getName());
        },"son thread").start();


    }
}
