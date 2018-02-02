package com.kf.practice.base;

import com.kf.practice.util.UuidUtil;

import java.io.Serializable;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/29
 */
public class SerializId implements Serializable {

    private String id;

    public SerializId() {
        this.id = UuidUtil.getUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
