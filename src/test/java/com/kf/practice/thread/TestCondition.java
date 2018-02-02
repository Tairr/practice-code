package com.kf.practice.thread;

import com.kf.practice.entity.LockAccount;
import com.kf.practice.entity.LockUser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestCondition {

    public static void main(String[] args) {

        LockAccount account = new LockAccount(2000);

        LockUser zs = new LockUser("9255","张三",account);

        LockUser zs1 = new LockUser("9255","张三他爸",account);

        LockUser zs2 = new LockUser("9255","张三他哥",account);

        LockUser zs3 = new LockUser("9255","张三他弟",account);


        Thread thread = new Thread(()->{
           zs.getAccount().save(1000,"张三");
        });

        Thread thread2 = new Thread(()->{
            zs.getAccount().save(500,"张三他爸");
        });

        Thread thread3 = new Thread(()->{
            zs.getAccount().save(100,"张三他哥");
        });

        Thread thread4 = new Thread(()->{
            zs.getAccount().cost(800,"张三他弟");
        });

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 110; i++) {
            
            service.execute(thread);
            service.execute(thread4);
            service.execute(thread2);
            service.execute(thread3);
        }


    }

}
