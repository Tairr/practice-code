package com.kf.practice.thread;

import com.kf.practice.entity.Account;
import com.kf.practice.entity.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TestLockClass {

    public static void main(String[] args) {


        Account account = new Account("922222",2000);

        ReadWriteLock lock = new ReentrantReadWriteLock(false);

        ExecutorService service = Executors.newFixedThreadPool(2);

        User user1 = new User("张三",account,1000,lock,false);
        User user2 = new User("张三他爸",account,-800,lock,false);
        User user3 = new User("张三他哥",account,-500,lock,false);
        User user4 = new User("张三他弟",account,0,lock,true);

        service.execute(user1);
        service.execute(user2);
        service.execute(user3);
        service.execute(user4);





    }


}
