package com.kf.practice.service;

import org.springframework.stereotype.Service;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
@Service
public class TestInterfaceImpl implements TestInterface {

    @Override
    public void test2() {

    }

    @Override
    public void test1() {
        System.out.println("TestInterfaceImpl test1");
    }
}
