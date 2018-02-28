package com.kf.practice.designModel;

import com.kf.practice.designModel.singleton.SingletonDemo;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/23
 */
public class TestMain {

    public static void main(String[] args) {
        SingletonTest test = SingletonTest.getInstance();
        System.out.println(test.getProperties());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.updateProperties();
        System.out.println(test.getProperties());


        SingletonDemo.TEST.otherMethods();

    }

}
