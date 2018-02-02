package com.kf.practice.controller;

import com.kf.practice.base.BaseController;
import com.kf.practice.exception.ParameterException;
import com.kf.practice.generics.Room;
import com.kf.practice.service.TestExceptionService;
import com.kf.practice.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
@RestController
@RequestMapping("/exp")
public class TestExceptionController extends BaseController{

    @Autowired
    private TestExceptionService exceptionService;

    @RequestMapping("/ctr")
    public ReturnMap ctrlRhrow(){
        throw new ParameterException("ctr throw");
//        return ReturnMap.ok();
    }

    @RequestMapping("/ser")
    public ReturnMap serRhrow(){

        exceptionService.method();
        return ReturnMap.ok();
    }

}
