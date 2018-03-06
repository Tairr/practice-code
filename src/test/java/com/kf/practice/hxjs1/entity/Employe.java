package com.kf.practice.hxjs1.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class Employe implements Cloneable {

    private String name;
    private int age;

    public Employe(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("father static block");
    }

    {
        System.out.println("father block");
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

    public void finalize(){
        System.out.println("before Employe destroye");
    }

    @Override
    public Employe clone() throws CloneNotSupportedException {
        return (Employe) super.clone();
    }
}
