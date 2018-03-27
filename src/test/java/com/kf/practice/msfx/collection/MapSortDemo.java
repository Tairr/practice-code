package com.kf.practice.msfx.collection;

import java.util.*;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/22
 */
public class MapSortDemo {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<String, String>();

        map.put("KFC", "kfc");
        map.put("WNBA", "wnba");
        map.put("NBA", "nba");
        map.put("CBA", "cba");

        Map<String ,String> resultMap = sortByKey(map);

        for(Map.Entry<String,String > entry:resultMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }


    public static Map<String,String> sortByKey(Map<String,String> map){

        if(map == null || map.isEmpty()){
            return null;
        }
        Map<String,String > sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;

    }


    public static Map<String,String> sortByValue(Map<String,String> map){
        if(map == null || map.isEmpty()){
            return null;
        }

        Map<String ,String > sortMap = new LinkedHashMap<>();
        List<Map.Entry<String,String>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList,new MapValueComparator());

        Iterator<Map.Entry<String,String>> iterator = entryList.iterator();
        Map.Entry<String,String> tmpEntry = null;
        while (iterator.hasNext()){
            tmpEntry = iterator.next();
            sortMap.put(tmpEntry.getKey(),tmpEntry.getValue());
        }
        return sortMap;
    }

}
