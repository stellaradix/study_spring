package com.example.spring5._01_container;

import com.example.spring5.bean.Greeter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetBeanTests {

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
	@DisplayName("빈 불러오기: getBean(빈 이름, 타입)")
	public void testGetBean1() {
		context = new AnnotationConfigApplicationContext(AppContext01.class);

		Greeter greeter = context.getBean("greeter", Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = name + ", 안녕하세요";

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("빈 불러오기: getBean(타입)")
	public void testGetBean2() {
		context = new AnnotationConfigApplicationContext(AppContext01.class);

		Greeter greeter = context.getBean(Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = name + ", 안녕하세요";

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("빈 불러오기: 예외 > 조건에 맞는 빈 없음")
	public void testGetBean3() {
		context = new AnnotationConfigApplicationContext(AppContext01.class);

		assertThrows(
				NoSuchBeanDefinitionException.class,
				() -> context.getBean("greet", Greeter.class)
		);
	}

	@Test
	@DisplayName("빈 불러오기: 예외 > 조건에 맞는 많은 빈")
	public void testGetBean4() {
		context = new AnnotationConfigApplicationContext(AppContext02.class);

		assertThrows(
				NoUniqueBeanDefinitionException.class,
				() -> context.getBean(Greeter.class)
		);
	}
}
