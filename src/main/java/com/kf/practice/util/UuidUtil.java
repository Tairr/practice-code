package com.kf.practice.util;

import java.util.UUID;

/**
 * Created by tangjinhui on 2017/10/30.
 */
public class UuidUtil {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-","");
        return uuid;
    }
}
