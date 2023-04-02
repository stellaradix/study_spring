package com.example.spring5_intro.ch02_start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*

Java Annotation 으로 스프링 컨테이너에서 관리할 객체 정보 설정

@Configuration
- AnnotationConfigApplicationContext 생성자에 인자로 입력
- 내부에 @Bean 설정 메서드로 객체 정보를 가짐

@Bean 설정 메서드
- 스프링 컨테이너에서 관리할 객체 정보 설정

*/

@Configuration
public class AppContext {

	// 객체 이름: (기본값) 메서드 이름
	@Bean
	public Greeter greeter1() {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요!");
		return greeter;
	}

	// 객체 이름: name 설정
	@Bean("greeter2")
	public Greeter greeter() {
		Greeter greeter = new Greeter();
		greeter.setFormat("안녕하세요, %s님!");
		return greeter;
	}

	// 객체 이름: value 설정
	@Bean(value = "greeter3")
	public Greeter greet() {
		Greeter greeter = new Greeter();
		greeter.setFormat("만나서 반갑습니다, %s님!");
		return greeter;
	}
}
