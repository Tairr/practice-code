package com.kf.practice.generics;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
public class Room<T> {

    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return this.t;
    }


}
