package com.kf.practice.controller;

import com.kf.practice.service.RedisService;
import com.kf.practice.service.impl.RedisServiceImpl;
import com.kf.practice.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/23
 */

//@EnableCaching
@RestController
@RequestMapping("/redis")
public class RedisController {

//    @Resource(name="myRedisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;

    @RequestMapping(method = RequestMethod.PUT)
    public ReturnMap  add(@RequestParam Map<String,Object> param){
        for(String key:param.keySet()){
            redisService.setObject(key,param.get(key));
        }
        return ReturnMap.ok();
    }

    @RequestMapping(value="/{key}",method = RequestMethod.GET)
    public ReturnMap  get(@PathVariable("key")String key){

        System.out.println(redisService.getClass().getName());

        return ReturnMap.ok().put("value",redisService.getObject(key));
    }

}
