package com.example.spring5._01_container;

import com.example.spring5.bean.Greeter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanNameTests {

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
	@DisplayName("빈 이름 설정 1: 메서드명")
	public void testBeanName01() {
		context = new AnnotationConfigApplicationContext(AppContext01.class);

		Greeter greeter = context.getBean("greeter", Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = name + ", 안녕하세요";

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("빈 이름 설정 2: @Bean name 속성 1")
	public void testBeanName02() {
		context = new AnnotationConfigApplicationContext(AppContext02.class);

		Greeter greeter = context.getBean("greeter1", Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = "안녕하세요, " + name;

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("빈 이름 설정 3: @Bean name 속성 2")
	public void testBeanName03() {
		context = new AnnotationConfigApplicationContext(AppContext02.class);

		Greeter greeter = context.getBean("greeter2", Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = "반갑습니다, " + name;

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("빈 이름 설정 4: @Bean value 속성")
	public void testBeanName04() {
		context = new AnnotationConfigApplicationContext(AppContext02.class);

		Greeter greeter = context.getBean("greeter3", Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = "Hello, " + name;

		assertEquals(actual, expect);
	}
}
