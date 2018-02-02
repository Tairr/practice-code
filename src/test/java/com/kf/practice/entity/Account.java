package com.kf.practice.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class Account {

    public Account(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }

    private String id ;
    private int cash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
