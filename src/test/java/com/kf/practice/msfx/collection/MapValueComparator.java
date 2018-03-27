package com.kf.practice.msfx.collection;

import java.util.Comparator;
import java.util.Map;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/22
 */
public class MapValueComparator implements Comparator<Map.Entry<String,String>> {

    @Override
    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}
