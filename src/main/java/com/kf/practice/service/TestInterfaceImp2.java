package com.kf.practice.service;

import org.springframework.stereotype.Service;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
@Service
public class TestInterfaceImp2  extends TestInterfaceImpl implements TestInterface2   {

    @Override
    public void test1() {
        System.out.println("TestInterfaceImpl2 test1");
    }

    @Override
    public void test2() {
        System.out.println("TestInterfaceImpl2 test2");
    }
}
