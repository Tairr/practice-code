package com.kf.practice.listener;

import com.kf.practice.craft.JianshuProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author tangjinhui
 * @Description：应用启动运行业务
 * @date 2018/1/29
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        JianshuProcessor jianshuProcessor = event.getApplicationContext().getBean(JianshuProcessor.class);
        System.out.println("=========startup events begin============");
        //jianshuProcessor.run(); //简书爬虫
        System.out.println("=========startup events end============");
    }
}
