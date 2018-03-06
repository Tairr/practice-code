package com.kf.practice.hxjs.unit3.hxjs.unit3.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class Manager extends Employe{

    private String title;

    // test private & protected
    public Manager(String name, int age, String title) {
        super(name, age);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
