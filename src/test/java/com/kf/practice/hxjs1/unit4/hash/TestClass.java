package com.kf.practice.hxjs1.unit4.hash;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class TestClass {

    public static void main(String[] args) {

        String a ="abcd";
        System.out.println("abcd  hash:"+a.hashCode());
        String b ="abcd";
        System.out.println("abcd2  hash:"+b.hashCode());
        String c = new String("abcd");
        System.out.println("new abcd  hash:"+c.hashCode());

        System.out.println("a==b:"+(a==b)+",a==c:"+(a==c));
        System.out.println("a equals b:"+(a.equals(b))+",a equals c:"+(a.equals(c)));

        int[] nums = {2,3};
        System.out.println("int[]  :"+ nums.hashCode());

    }

}
