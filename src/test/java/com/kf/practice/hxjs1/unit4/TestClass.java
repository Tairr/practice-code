package com.kf.practice.hxjs1.unit4;

import com.kf.practice.hxjs.unit3.hxjs.unit3.entity.Employe;
import com.kf.practice.hxjs.unit3.hxjs.unit3.entity.Manager;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class TestClass {

    public static void main(String[] args) {

        Employe employe = new Employe("zs",16);
        Manager manager = new Manager("zs",17,"master");

        Employe employe1 = new Employe("ls",12);

        int a = 1,b=2;

        // b改变不影响a改变
        a = b;
        b = 3;

        System.out.println("a:"+a);

        Class emClass = employe.getClass();

        // employe1改变影响employe2
        Employe  employe2 = employe1;
        employe1.setName("test3");
        System.out.println("employe2:"+employe2.getName());

        // 强制转换到父 再到 子，不丢失子独有的属性
        Employe e = (Employe)manager;
        Manager m =(Manager)e;
        System.out.println("after trans:"+m.getTitle());

    }

}
