package com.kf.practice.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class LockUser {

    private String id;
    private String name;

    private LockAccount account;

    public LockUser(String id, String name,LockAccount account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LockAccount getAccount() {
        return account;
    }

    public void setAccount(LockAccount account) {
        this.account = account;
    }
}
