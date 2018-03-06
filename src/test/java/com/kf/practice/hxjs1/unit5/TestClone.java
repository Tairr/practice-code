package com.kf.practice.hxjs1.unit5;


import com.kf.practice.hxjs1.entity.Employe;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class TestClone {
    public static void main(String[] args) {

        Employe e = new Employe("zs",11);

        System.out.println(e.getClass() == Employe.class);

        try {

            Employe ec = e.clone();
            System.out.println(ec.getAge());
            e.setAge(1111);
            System.out.println(ec.getAge());
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }

    }

}
