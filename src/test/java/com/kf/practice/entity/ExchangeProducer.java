package com.kf.practice.entity;

import javax.annotation.security.RunAs;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/1
 */
public class ExchangeProducer  implements Runnable{

    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public ExchangeProducer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        int cycle =1;
        for (int i = 0; i <5 ; i++) {

         //   System.out.println("Producer:cycle:"+cycle);
            buffer.add(Thread.currentThread().getName());
            for (int j = 0; j < 2; j++) {
                String msg = "Event "+(i*10+j);
               // System.out.println("Producer:"+msg);
                buffer.add(msg);
            }

            try {
                System.out.println(Thread.currentThread().getName()+",Producer:before exchange:"+buffer);
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName()+",Producer:after exchange:"+buffer);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
           // System.out.println("Producer:"+buffer.size());
            cycle++;
        }


    }
}
