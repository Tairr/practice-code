package com.kf.practice.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/5
 */

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void proccer(String hello){
        System.out.println("Receiver:"+hello);
    }


}
