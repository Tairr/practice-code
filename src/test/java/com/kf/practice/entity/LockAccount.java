package com.kf.practice.entity;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class LockAccount {

    private int cash;

    private Lock lock = new ReentrantLock();

    private Condition save = lock.newCondition();
    private Condition cost = lock.newCondition();

    public LockAccount(int cash) {
        this.cash = cash;
    }


    public void save (int amount,String name){
        lock.lock();
        try {
            this.cash = this.cash + amount;
            System.out.println(name + "存款" + amount + "，当前余额为" + cash);
            cost.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void cost (int amount,String name){
        lock.lock();
        try {
            if(cash-amount<0) {
                cost.await();
            }else {
                this.cash = this.cash - amount;
                System.out.println(name + "取款" + amount + "，当前余额为" + cash);
            }
            save.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}
