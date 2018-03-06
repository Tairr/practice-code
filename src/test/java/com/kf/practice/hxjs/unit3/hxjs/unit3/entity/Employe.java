package com.kf.practice.hxjs.unit3.hxjs.unit3.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class Employe {

    private String name;
    private int age;

    public Employe(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
