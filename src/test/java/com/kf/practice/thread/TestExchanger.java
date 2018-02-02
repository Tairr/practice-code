package com.kf.practice.thread;

import com.kf.practice.entity.ExchangeConsumer;
import com.kf.practice.entity.ExchangeProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author tangjinhui
 * @Description： 同步点 : Exchanger在生产-消费者问题情境中非常有用。
 *
 * @date 2018/2/1
 */
public class TestExchanger {

    public static void main(String[] args) {

        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();
        List<String> buffer3 = new ArrayList<>();
        List<String> buffer4 = new ArrayList<>();

        Exchanger<List<String>> exchanger = new Exchanger<>();

        Thread producer = new Thread(new ExchangeProducer(buffer1,exchanger),"pro1");
        Thread consumer = new Thread(new ExchangeConsumer(buffer2,exchanger),"con1");

        Thread producer2 = new Thread(new ExchangeProducer(buffer3,exchanger),"pro2");
        Thread consumer2 = new Thread(new ExchangeConsumer(buffer4,exchanger),"con2");

        producer.start();
        consumer.start();

        producer2.start();
        //consumer2.start();


    }


}
