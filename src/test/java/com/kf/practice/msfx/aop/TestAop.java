package com.kf.practice.msfx.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/8
 */
public class TestAop {

    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();

        TestAopImp testAopImp = (TestAopImp)proxy.getProxy(TestAopImp.class);

        testAopImp.test();


        TestAopInterface testAopImp1 = new TestAopImp();
        Class[] classes = {TestAopInterface.class};

        TestAopInterface testAopImp11 = (TestAopInterface) Proxy.newProxyInstance(TestAop.class.getClassLoader(), classes, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy before");
                if(method.getName().equals("test"))
                    method.invoke(testAopImp1,args);
                System.out.println("proxy after");

                return null;
            }
        });

        testAopImp11.test();

    }

}
