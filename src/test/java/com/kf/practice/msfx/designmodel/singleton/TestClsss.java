package com.kf.practice.msfx.designmodel.singleton;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/12
 */
public class TestClsss {

    public static void main(String[] args) {

       // Account A =  SingletonClass.A;

        SingletonClass s = SingletonClass.SA;

        System.out.println(s.getAttr());
    }

}
