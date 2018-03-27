package com.kf.practice.msfx.designmodel.singleton;

import com.kf.practice.entity.Account;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/12
 */
public enum SingletonClass {

    SA{
        public String getAttr() {
            return "SA";
        }

    },SB;

    private String name;
    private String attr;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}
