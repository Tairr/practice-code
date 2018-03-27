package com.kf.practice.hxjs1.unit8.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/21
 */
public class BianliList {


    public static void main(String[] args) {

        List list = new ArrayList<String>();

        list.add("a");

    }



    public static void forindex(List a){
        for (int i = 0; i < a.size(); i++) {
            System.out.println("forindex:"+a.get(i));
        }
    }

    public static void fori(List a) {
        for(Object o:a){
            System.out.println("fori:"+a);
        }
    }


    public static void iter(List a){

        Iterator iterator = a.iterator();
        while (iterator.hasNext()){
            System.out.println("iter:"+iterator.next());
        }

    }

}
