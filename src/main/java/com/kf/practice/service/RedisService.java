package com.kf.practice.service;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/23
 */
public interface RedisService {

    public void  set(String key, String value);

    public String get(String key);

    public void  setObject(String key, Object value);

    public Object getObject(String key);

    public boolean expire(String key, long timeout);

    public void delete(String key);

}
