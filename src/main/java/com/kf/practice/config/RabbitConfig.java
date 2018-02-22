package com.kf.practice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/5
 */

@Configuration
public class RabbitConfig {


    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }

    @Bean
    public Queue neoQueque(){
        return new Queue("neo");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("object");
    }



}
