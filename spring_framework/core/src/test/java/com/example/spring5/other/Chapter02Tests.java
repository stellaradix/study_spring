package com.example.spring5.other;

import com.example.spring5_intro.ch02_start.AppContext;
import com.example.spring5_intro.ch02_start.Greeter;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter02Tests {



	private GenericApplicationContext context;

	@BeforeEach
	public void openApplicationContext() {
		/*

		@Configuration 설정 클래스는
		AnnotationConfigApplicationContext 생성자에 인자로 입력되어

		내부의 @Bean 설정 메서드에서 반환하는 객체를
		스프링 컨테이너에 등록할 수 있다

		*/
		context = new AnnotationConfigApplicationContext(AppContext.class);
	}

	@AfterEach
	public void closeApplicationContext() {
		// 어플리케이션 종료전 스프링 컨테이너 종료
		// 자원 관리, 메모리 누수 방지
		context.close();
	}

	@Test
	@DisplayName("Application Context: 스프링 컨테이너")
	public void testApplicationContext() {
		// containsBean(Bean 이름): 스프링 컨테이너에 해당하는 이름의 객체 확인

		// @Bean 어노테이션 기본 - 메서드 이름으로 객체 이름 지정
		assertTrue(context.containsBean("greeter1"));

		// @Bean: name 옵션 - name 옵션으로 객체 이름 지정, 메서드 이름 x
		assertTrue(context.containsBean("greeter2"));
		assertFalse(context.containsBean("greeter"));

		// @Bean: value 옵션 - value 옵션으로 객체 이름 지정, 메서드 이름 x
		assertTrue(context.containsBean("greeter3"));
		assertFalse(context.containsBean("greet"));
	}

	@Test
	@DisplayName("@Bean 메서드마다 한 객체: 같은 객체 1")
	public void singletonPerBean1() {
		Greeter greeter1 = context.getBean("greeter1", Greeter.class);
		Greeter greeter2 = context.getBean("greeter1", Greeter.class);

		assertSame(greeter1, greeter2);
	}

	@Test
	@DisplayName("@Bean 메서드마다 한 객체: 같은 객체 2")
	public void singletonPerBean2() {
		Greeter greeter1 = context.getBean("greeter2", Greeter.class);
		Greeter greeter2 = context.getBean("greeter2", Greeter.class);

		assertSame(greeter1, greeter2);
	}

	@Test
	@DisplayName("@Bean 메서드마다 한 객체: 다른 객체")
	public void oneObjectPerBean() {
		Greeter greeter1 = context.getBean("greeter1", Greeter.class);
		Greeter greeter2 = context.getBean("greeter2", Greeter.class);

		assertNotSame(greeter1, greeter2);
	}

	@Test
	@DisplayName("greeter1 객체 테스트")
	public void testGreeter1() {
		Greeter greeter = context.getBean("greeter1", Greeter.class);

		String name = "스프링 5";
		String actual = greeter.greet(name);
		String expect = name + ", 안녕하세요!";

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("greeter2 객체 테스트")
	public void testGreeter2() {
		Greeter greeter = context.getBean("greeter2", Greeter.class);

		String name = "스프링";
		String actual = greeter.greet(name);
		String expect = "안녕하세요, " + name + "님!";

		assertEquals(actual, expect);
	}

	@Test
	@DisplayName("greeter3 객체 테스트")
	public void testGreeter3() {
		Greeter greeter = context.getBean("greeter3", Greeter.class);

		String name = "스프링 프레임워크";
		String actual = greeter.greet(name);
		String expect = "만나서 반갑습니다, " + name + "님!";

		assertEquals(actual, expect);
	}
}
