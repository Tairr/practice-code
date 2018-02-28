package com.kf.practice.designModel.prototype;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/23
 */
public class ProtoType implements Cloneable {

    public Object clone() throws CloneNotSupportedException{
        ProtoType protoType = (ProtoType)super.clone();
        return protoType;
    }

}
