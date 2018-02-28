package com.kf.practice.collection.treemap;

import java.util.TreeMap;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/27
 */
public class TestClass {

    public static void main(String[] args) {

        TreeMap map = new TreeMap();

        map.put("z",11);
        map.put("d",4);
        map.put("b",2);
        map.put("c",3);

        System.out.println("map.firstEntry().getKey():"+map.firstEntry().getKey());
        System.out.println("map.lastEntry().getKey():"+map.lastEntry().getKey());


    }

}
