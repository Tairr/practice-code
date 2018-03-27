package com.kf.practice.msfx.aop;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/26
 */
public class CglibTestProxy implements MethodInterceptor {

    private Enhancer enhancer= new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = proxy.invoke(obj,args);
        return result;
    }
}
