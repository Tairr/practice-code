package com.kf.practice.entity;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class User implements Runnable {


    @Override
    public void run() {

        if(isCheck){
            locak.readLock().lock();
            System.out.println("读操作;余额："+account.getCash());
            locak.readLock().unlock();
        }else{
            locak.writeLock().lock();
            account.setCash(account.getCash()+iocash);
            System.out.println("写操作;余额："+account.getCash());
            locak.writeLock().unlock();
        }


    }

    private String name;
    private Account account;

    private int iocash;
    private ReadWriteLock locak;
    private boolean isCheck;


    public User(String name, Account account, int iocash, ReadWriteLock locak, boolean isCheck) {
        this.name = name;
        this.account = account;
        this.iocash = iocash;
        this.locak = locak;
        this.isCheck = isCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getIocash() {
        return iocash;
    }

    public void setIocash(int iocash) {
        this.iocash = iocash;
    }

    public ReadWriteLock getLocak() {
        return locak;
    }

    public void setLocak(ReadWriteLock locak) {
        this.locak = locak;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
