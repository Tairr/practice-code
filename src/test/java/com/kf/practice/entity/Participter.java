package com.kf.practice.entity;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class Participter implements Runnable {

    private String name;
    private Conference conference;

    public Participter(String name, Conference conference) {
        this.name = name;
        this.conference = conference;
    }

    @Override
    public void run() {
        conference.arraive(name);

    }
}
