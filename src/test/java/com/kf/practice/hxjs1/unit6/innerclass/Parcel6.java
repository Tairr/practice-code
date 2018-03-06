package com.kf.practice.hxjs1.unit6.innerclass;

/**
 * @author tangjinhui
 * @Description： 局部内部类 定义在作用域内
 * @date 2018/3/2
 */
public class Parcel6 {
    private void internalTracking(boolean b){
        if(b){  // 定义在作用域内 if方法块内
            class TrackingSlip{
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("chenssy");
            String string = ts.getSlip();
        }
    }

    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
