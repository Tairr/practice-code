package com.kf.practice.controller;

import com.kf.practice.service.impl.RedisServiceImpl;
import com.kf.practice.util.ReturnMap;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/23
 */

@RestController
@RequestMapping("/ho")
public class HelloController {

    @Autowired
    private RedisServiceImpl service;

    @RequestMapping("/index")
    public ReturnMap index(){
        return ReturnMap.ok("Hello index");
    }



}
