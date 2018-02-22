package com.kf.practice;

import com.kf.practice.rabbit.HelloSender;
import com.kf.practice.service.TestInterfaceImp2;
import com.kf.practice.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracticeApplicationTests {

	@Autowired
	private TestInterfaceImp2 interfaceImp2;


	@Test
	public void testInterface() {
		interfaceImp2.test1();
		interfaceImp2.test2();
	}

	@Test
	public void testSetUtil() {
		Set set1 = IntStream.range(1,20)
				.boxed().collect(Collectors.toSet());

		Set set2 = IntStream.range(15,27)
				.boxed().collect(Collectors.toSet());

		Set result = CommonUtils.ferIntersection(set1,set2);
		for(Object i :result){
			System.out.println("value:"+(Integer)i);
		}
	}


	@Test
	public void contextLoads() {
		// AbstractRefreshableApplicationContext
	}

	@Test
	public void testIntAnd(){
		System.out.println(18 & 15);
	}


	@Test
	public void testThread(){
		System.out.println(18 & 15);
	}


	/**
	 * test rabbitmq
	 */
	@Autowired
	private HelloSender helloSender;

	@Test
	public void testRabbit(){
		helloSender.send();
	}
}
