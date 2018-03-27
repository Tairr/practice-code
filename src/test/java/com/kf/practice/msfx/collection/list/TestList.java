package com.kf.practice.msfx.collection.list;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/22
 */
public class TestList {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(22);

        //error
        //Integer[] a = (Integer[]) list.toArray();

        Integer[] b = list.toArray(new Integer[0]);

        Integer[] c = (Integer[])list.toArray(new Integer[0]);

        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

        System.out.println(list.size());

        Map hashtable = new Hashtable();
        hashtable.size();



    }

}
