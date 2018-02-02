package com.kf.practice.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
public  class CommonUtils {

    public static <E> Set ferIntersection(Set<E> set1,Set<E> set2){
        Set result = new HashSet();
        for(E o: set1){
            if(set2.contains(o)) {
                result.add(o);
            }
        }
        return result;

    }

}
