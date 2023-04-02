package com.example.spring5._01_container;

import com.example.spring5.bean.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext02 {

	@Bean("greeter1")
	public Greeter greet1() {
		Greeter greeter = new Greeter();
		greeter.setFormat("안녕하세요, %s");
		return greeter;
	}

	@Bean(name = "greeter2")
	public Greeter greet2() {
		Greeter greeter = new Greeter();
		greeter.setFormat("반갑습니다, %s");
		return greeter;
	}

	@Bean(value = "greeter3")
	public Greeter greet3() {
		Greeter greeter = new Greeter();
		greeter.setFormat("Hello, %s");
		return greeter;
	}
}
