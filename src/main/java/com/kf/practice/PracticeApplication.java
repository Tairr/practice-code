package com.kf.practice;

import com.kf.practice.listener.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}


	@Bean
	public ApplicationStartup applicationStartup(){
		return new ApplicationStartup();
	}


	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
		return new ThreadPoolTaskExecutor();
	}

}
