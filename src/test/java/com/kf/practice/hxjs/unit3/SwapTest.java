package com.kf.practice.hxjs.unit3;

import com.kf.practice.hxjs.unit3.hxjs.unit3.entity.Employe;
import com.kf.practice.hxjs.unit3.hxjs.unit3.entity.Manager;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class SwapTest {

    public static void main(String[] args) {

        Employe employe = new Employe("zs",16);
        Manager  manager = new Manager("zs",17,"master");

        // swap和 swapInt 都没效果
        Employe employe1 = new Employe("ls",12);
        swap(employe,employe1);
        System.out.println("Employe after swap:"+employe.getName()+","+employe1.getName());

        int a = 1,b=2;
        swapInt(a,b);
        System.out.println("int after swap:"+a+","+b);

        // b改变不影响a改变
        a = b;
        b = 3;

        System.out.println("a:"+a);

        // employe1改变影响employe2
        Employe  employe2 = employe1;
        employe1.setName("test3");
        System.out.println("employe2:"+employe2.getName());

        // 强制转换到父 再到 子，不丢失子独有的属性
        Employe e = (Employe)manager;
        Manager m =(Manager)e;
        System.out.println("after trans:"+m.getTitle());

    }


    public static void swap(Employe a,Employe b){

        Employe temp = a;
        a = b;
        b = temp;
    }

    public static void swapInt(int a,int b){

        int temp = a;
        a= b;
        b =temp;

    }
}
