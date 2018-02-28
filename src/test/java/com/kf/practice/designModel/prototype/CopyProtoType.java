package com.kf.practice.designModel.prototype;

import java.io.*;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/23
 */
public class CopyProtoType implements Cloneable,Serializable {

    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject obj;


    public Object clone() throws CloneNotSupportedException{
        CopyProtoType type = (CopyProtoType)super.clone();
        return  type;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();

    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    class SerializableObject implements Serializable{
        private static final long serialVersionUID =1L;
    }

}
