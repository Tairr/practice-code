package com.kf.practice.hxjs1.unit6.innerclass;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class TestInnerClass {

    public static void main(String[] args) {

        OuterClass out = new OuterClass("zs",11);

        // new 成员内部类
        // 无get方法获取时
        OuterClass.InnerClass inner = out. new InnerClass();
        // 用get方法时
        OuterClass.InnerClass inner2 = out.getInnerClass();
        inner.disPlay();


    }

}
