package com.kf.practice.hxjs1.unit5;

import com.kf.practice.hxjs1.entity.Employe;
import com.kf.practice.hxjs1.entity.MyInterfaceImpl;
import com.kf.practice.hxjs1.iffolds.MyInterface;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class TestReflect {

    public static void main(String[] args) throws IllegalAccessException {

        Object obj = new Object();
        for (Field f : obj.getClass().getDeclaredFields()) {

            f.setAccessible(true);
            Object value = f.get(obj);

//            f.setDouble(obj, value*1.2);   ??

        }

        MyInterface myInterface = new MyInterfaceImpl();

        // 注意 newProxyInstance 的第二个参数！！！！ MyInterface.class.getInterfaces 无法成功 myInterface.getClass().getInterfaces()和cs可以成功
        ClassLoader loader = TestReflect.class.getClassLoader();
        Class[] cs = {MyInterface.class};

        MyInterface myInterfaceProxy = (MyInterface)Proxy.newProxyInstance(MyInterface.class.getClassLoader(), myInterface.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("服务前");
                if(method.getName().equals("test"))
                    method.invoke(myInterface,args);
                System.out.println("服务后");
                return null;
            }
        });

        myInterfaceProxy.test();
//   !!!  throws classcastexception
//        Object[] values = new Object[1000];
//        for(int i=0;i<values.length;i++){
//            Object value = new Employe("zs",i);
//            values[i] = (Object) Proxy.newProxyInstance(null,
//                    value.getClass().getInterfaces(),
//        //调用处理器的lambda表达式
//                    (Object proxy, Method m ,Object[] margs)->{
//                        System.out.println(value+m.getName()+ Arrays.toString(margs));
//                        return m.invoke(value,margs);
//                    });
//        }



        MyInterface[] a ={myInterfaceProxy};
        System.out.println((myInterfaceProxy==null)+","+(a[0]==null));
        MyInterface[] b = (MyInterface[]) getGoodCopyOf(a,10);

        System.out.println(Arrays.toString((MyInterface[]) getGoodCopyOf(a,10)));

    }

    public static Object getGoodCopyOf(Object a , int newLength){
        Class c1 = a.getClass();
        if(!c1.isArray())
            return null;

        Class componentType = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
