package com.kf.practice.entity;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class ExchangeConsumer implements Runnable {

    private List<String> buffer ;
    private final Exchanger<List<String>> exchanger;

    public ExchangeConsumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        
        int cycle=1;

        for (int i = 0; i <10 ; i++) {

           // System.out.println("Consumer:cycle:"+cycle);
            try {
                System.out.println(Thread.currentThread().getName()+",Consumer:before exchange:"+buffer);
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName()+",Consumer:after exchange:"+buffer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //System.out.println("Consumer:"+buffer.size());
            for (int j = 0; j <10 ; j++) {
               // System.out.println("Consumer:"+ buffer.get(0));
                buffer.remove(0);
            }
            cycle++;
        }
        

    }
}
