package com.kf.practice.thread;

import java.util.concurrent.*;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestThreadCallable {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);

        Callable callable = new MyCallable("1");
        Callable callable1 = new MyCallable("2");
        Callable callable2 = new MyCallable("3");
        Callable callable3 = new MyCallable("4");
        Callable callable4 = new MyCallable("5");

        Future future = service.submit(callable);
        Future future1 = service.submit(callable1);
        Future future2 = service.submit(callable2);
        Future future3 = service.submit(callable3);
        Future future4 = service.submit(callable4);


        System.out.println(future.get().toString());
        System.out.println(future1.get().toString());
        System.out.println(future2.get().toString());
        System.out.println(future3.get().toString());
        System.out.println(future4.get().toString());


    }




}
