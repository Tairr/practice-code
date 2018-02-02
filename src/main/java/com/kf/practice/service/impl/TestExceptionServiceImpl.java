package com.kf.practice.service.impl;

import com.kf.practice.exception.BusinessException;
import com.kf.practice.service.TestExceptionService;
import org.springframework.stereotype.Service;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
@Service
public class TestExceptionServiceImpl implements TestExceptionService {

    @Override
    public void method() {
        throw new BusinessException("service throw");
    }
}
