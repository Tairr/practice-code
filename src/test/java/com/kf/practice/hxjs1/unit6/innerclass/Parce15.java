package com.kf.practice.hxjs1.unit6.innerclass;

/**
 * @author tangjinhui
 * @Description： 局部内部类 定义在方法
 * @date 2018/3/2
 */
public class Parce15 {

    public Destionation destionation(String str){

        class PDestionation implements Destionation{
            private String label;
            private PDestionation(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }

        return new PDestionation(str);
    }

    public static void main(String[] args) {
        Parce15 parcel5 = new Parce15();
        Destionation d = parcel5.destionation("chenssy");
    }
}
