package com.kf.practice.base;

import com.kf.practice.exception.BusinessException;
import com.kf.practice.exception.ParameterException;
import com.kf.practice.util.ReturnMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
@RestController
public class BaseController {

    @ExceptionHandler
    public ReturnMap handleException(HttpServletRequest request, Exception ex) {
        if(ex instanceof ParameterException){
            return ReturnMap.error("param exception");
        }else if(ex instanceof BusinessException){
            return ReturnMap.error("business exception");
        }
        return ReturnMap.error();
    }

}
