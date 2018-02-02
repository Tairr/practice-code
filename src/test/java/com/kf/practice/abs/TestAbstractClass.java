package com.kf.practice.abs;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public abstract class TestAbstractClass {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void method(){
        System.out.println("abs");
    }

}
