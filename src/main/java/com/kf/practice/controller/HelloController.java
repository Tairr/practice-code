package com.kf.practice.controller;

import com.kf.practice.util.ReturnMap;
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

    @RequestMapping("/index")
    public ReturnMap index(){
        return ReturnMap.ok("Hello index");
    }

}
