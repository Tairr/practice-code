package com.kf.practice.msfx.collection;

import java.util.Comparator;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/22
 */
public class MapKeyComparator implements Comparator<String> {

    @Override
    public int compare(String str1,String str2) {
        return str1.compareTo(str2);
    }
}
