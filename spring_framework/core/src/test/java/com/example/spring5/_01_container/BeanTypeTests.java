package com.example.spring5._01_container;

import com.example.spring5.bean.Greeter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanTypeTests {

	/**
	 * 스프링 컨테이너 객체
	 */
	private GenericApplicationContext context;

	/**
	 * 프로그램 종료전 스프링 컨테이너 종료
	 */
	@AfterEach
	public void closeApplicationContext() {
		context.close();
	}

	@Test
	@DisplayName("기본설정 @Bean 싱글톤 1")
	public void testBeanSingleton() {
		context = new AnnotationConfigApplicationContext(AppContext01.class);

		Greeter greeter1 = context.getBean("greeter", Greeter.class);
		Greeter greeter2 = context.getBean(Greeter.class);

		assertEquals(greeter1, greeter2);
	}
}
