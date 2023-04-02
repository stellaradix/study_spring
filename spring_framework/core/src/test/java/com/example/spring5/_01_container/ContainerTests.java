package com.example.spring5._01_container;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainerTests {

	/**
	 * <p>
	 * BeanFactory<br>
	 * <- ListableBeanFactory<br>
	 * <- ApplicationContext<br>
	 * <- ConfigurableApplicationContext<br>
	 * <- AbstractApplicationContext<br>
	 * <- GenericApplicationContext<br>
	 * </p>
	 * <p>
	 * 스프링의 핵심 기능 1: 객체의 관리 by 스프링 컨테이너<br>
	 * - BeanFactory 인터페이스를 구현한 객체가 스프링 컨테이너<br>
	 * - ApplicationContext 는 BeanFactory 외 다른 역할도 수행<br>
	 * - 설정된 객체의 정보를 가지고 객체의 사이클을 관리<br>
	 * </p>
	 * <p>
	 * 빈 객체: 스프링 컨테이너에서 관리할 객체
	 * </p>
	 * <p>
	 * GenericApplicationContext 의 하위 클래스<br>
	 * : 빈 객체 정보를 어디에서 가져오는가에 따라 생성할 클래스 달라짐<br>
	 * </p>
	 * <p>
	 * - AnnotationConfigApplicationContext: Java 어노테이션에 빈 객체 정보 설정<br>
	 * - GenericXmlApplicationContext: XML 파일에 빈 객체 정보 설정<br>
	 * - GenericGroovyApplicationContext: Groovy 코드로 빈 객체 정보 설정<br>
	 * </p>
	 */
	private GenericApplicationContext context;

	/**
	 * 프로그램 종료전 스프링 컨테이너 종료<br>
	 * - 자원 관리, 메모리 누수 방지
	 */
	@AfterEach
	public void closeApplicationContext() {
		context.close();
	}

	/**
	 * <p>
	 * 스프링 컨테이너 객체 생성: BeanFactory 상속
	 * </p>
	 * <p>
	 * 스프링 컨테이너 객체인 AnnotationConfigApplicationContext 객체가 초기화 될 때,<br>
	 * - @Configuration 설정한 클래스가 생성자의 인자로 전달되어 관리할 빈 객체의 정보를 전달<br>
	 * </p>
	 * <p>
	 * 빈 객체 수동 설정
	 * -
	 * </p>
	 * <p>
	 * 스프링 컨테이너의 설정 클래스: AppContext01.class
	 * </p>
	 */
	@Test
	@DisplayName("컨테이너 1: 단일 파일 AppContext 01")
	public void testContainer01() {
		context = new AnnotationConfigApplicationContext(AppContext01.class);

		assertTrue(context.containsBean("greeter"));

		assertFalse(context.containsBean("greeter1"));
		assertFalse(context.containsBean("greet1"));

		assertFalse(context.containsBean("greeter2"));
		assertFalse(context.containsBean("greet2"));

		assertFalse(context.containsBean("greeter3"));
		assertFalse(context.containsBean("greet3"));
	}

	/**
	 * <p>
	 * 스프링 컨테이너의 설정 클래스: AppContext02.class
	 * </p>
	 */
	@Test
	@DisplayName("컨테이너 2: 단일 파일 AppContext 02")
	public void testContainer02() {
		context = new AnnotationConfigApplicationContext(AppContext02.class);

		assertFalse(context.containsBean("greeter"));

		assertTrue(context.containsBean("greeter1"));
		assertFalse(context.containsBean("greet1"));

		assertTrue(context.containsBean("greeter2"));
		assertFalse(context.containsBean("greet2"));

		assertTrue(context.containsBean("greeter3"));
		assertFalse(context.containsBean("greet3"));
	}

	/**
	 * <p>
	 * 스프링 컨테이너 설정 파일 여러개 사용: 생성자에 여러개 파일 인자로 전달 (가변인자)
	 * </p>
	 * <p>
	 * ex) new AnnotationConfigApplicationContext(AppContext01.class, AppContext02.class)
	 * </p>
	 */
	@Test
	@DisplayName("컨테이너 3: 여러 파일 AppContext 01, 02")
	public void testContainer03() {
		context = new AnnotationConfigApplicationContext(AppContext01.class, AppContext02.class);

		assertTrue(context.containsBean("greeter"));

		assertTrue(context.containsBean("greeter1"));
		assertFalse(context.containsBean("greet1"));

		assertTrue(context.containsBean("greeter2"));
		assertFalse(context.containsBean("greet2"));

		assertTrue(context.containsBean("greeter3"));
		assertFalse(context.containsBean("greet3"));
	}

	/**
	 * <p>
	 * 스프링 컨테이너 설정 파일 여러개 사용: 설정 파일에 @Import 사용
	 * </p>
	 * <p>
	 * ex) @Import(AppContext01.class)<br>
	 * ex) @Import({AppContext01.class, AppContext02.class})<br>
	 * </p>
	 */
	@Test
	@DisplayName("컨테이너 4: 여러 파일 AppContext 01, 02")
	public void testContainer04() {
		context = new AnnotationConfigApplicationContext(AppContext03.class);

		assertTrue(context.containsBean("greeter"));

		assertTrue(context.containsBean("greeter1"));
		assertFalse(context.containsBean("greet1"));

		assertTrue(context.containsBean("greeter2"));
		assertFalse(context.containsBean("greet2"));

		assertTrue(context.containsBean("greeter3"));
		assertFalse(context.containsBean("greet3"));
	}
}
