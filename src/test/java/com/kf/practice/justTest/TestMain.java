package com.kf.practice.justTest;

/**
 * @author tangjinhui
 * @Description：java静态同步方法底层实现？ https://www.zhihu.com/question/265677213/answer/297691281
 * @date 2018/2/23
 */
public class TestMain {

    public static void main(String[] args) {

        Foo obj = new Foo();
        Class<?> clazz = obj.getClass();
        System.out.println (clazz == Foo.class);

        Class<?> clasZ = clazz.getClass();
        System.out.println(clasZ == Class.class);


    }

}
