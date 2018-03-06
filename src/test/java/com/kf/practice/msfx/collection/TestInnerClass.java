package com.kf.practice.msfx.collection;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/6
 */
public class TestInnerClass {

    Inner node;

    class Inner{

        int data ;
        Inner next;

        public Inner(int data,Inner next) {
            this.data = data;
            this.next = next;
        }
    }

}
