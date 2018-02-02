package com.kf.practice.thread;

import java.util.concurrent.Callable;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */

class MyCallable implements Callable {

    private String oid;

    public MyCallable(String oid) {
        this.oid = oid;
    }

    @Override
    public Object call() throws Exception {
        return "返回："+oid;
    }
}
