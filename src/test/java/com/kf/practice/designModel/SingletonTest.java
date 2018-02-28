package com.kf.practice.designModel;

import java.util.Date;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/23
 */
public class SingletonTest {

    private static SingletonTest instance = null;

    private String properties = null;

    private static synchronized void cinit(){
        if(instance == null)
            instance = new SingletonTest();
    }

    private SingletonTest(){
        this.properties = new Date().toString();
    }

    public static SingletonTest getInstance(){
        if(instance == null)
            cinit();
        return instance;
    }

    public String getProperties() {
        return properties;
    }

    public void updateProperties(){
        SingletonTest shadow = new SingletonTest();
        properties = shadow.getProperties();
    }
}
