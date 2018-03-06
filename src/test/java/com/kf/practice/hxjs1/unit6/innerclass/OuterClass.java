package com.kf.practice.hxjs1.unit6.innerclass;

/**
 * @author tangjinhui
 * @Description： 成员内部类
 * @date 2018/3/2
 */
public class OuterClass {

    private String name;
    private int age;

    public OuterClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public class InnerClass{

        public void disPlay(){
            System.out.println("name:"+name+",age:"+age);
        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
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
