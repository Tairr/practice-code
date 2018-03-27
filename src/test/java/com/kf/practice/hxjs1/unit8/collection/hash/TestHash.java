package com.kf.practice.hxjs1.unit8.collection.hash;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/5
 */
public class TestHash {

    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap();

        map.put(1,"a");
        map.put(11,"a");
        map.put(12,"a");
        map.put(13,"a");
        map.put(111,"a");
        map.put(121,"a");
        map.put(131,"a");
        map.put(112,"a");
        map.put(122,"a");
        map.put(132,"a");


        Iterator i = map.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry entry = (Map.Entry)i.next();
            System.out.println("hashcode:"+entry.hashCode()+",value:"+entry.getKey());
        }

        Set set = new HashSet();

    }


}
