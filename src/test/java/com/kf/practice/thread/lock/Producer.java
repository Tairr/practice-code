package com.kf.practice.thread.lock;

import javax.annotation.security.RunAs;
import java.util.LinkedList;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/28
 */
public class Producer implements Runnable{

    private LinkedList list;
    private int maxSize;

    public Producer(LinkedList list,int maxSize) {
        this.maxSize=maxSize;
        this.list = list;
    }

    @Override
    public void run() {

        if(list.size()==maxSize){

        }

    }
}
