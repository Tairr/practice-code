package com.kf.practice.hxjs1.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class Manager extends Employe {

    private String title;

    // test private & protected
    public Manager(String name, int age, String title) {
        super(name, age);
        this.title = title;
    }

    static {
        System.out.println("child static block");
    }

    {
        System.out.println("child block");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void finalize() {
        System.out.println("before Manager destroye");
    }
}
