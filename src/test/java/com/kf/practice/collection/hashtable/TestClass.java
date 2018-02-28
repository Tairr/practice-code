package com.kf.practice.collection.hashtable;

import java.util.*;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/27
 */
public class TestClass {

    public static void main(String[] args) {

        Map map = new Hashtable<String,Object>();

        map.put("a",11);

        Iterator i = map.entrySet().iterator();
        while (i.hasNext()){
            Map.Entry e =  (Map.Entry)i.next();
            String key = (String) e.getKey();

            Object value = e.getValue();

            System.out.println("key:"+key+",value:"+value);
        }

        // 不能用  Map hmap = new Hashtable<String,Object>();
        Hashtable hmap = new Hashtable<String,Object>();
        Enumeration enu = hmap.keys();
        while(enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }

        TreeMap treeMap = new TreeMap();

        treeMap.firstEntry();

    }

}
