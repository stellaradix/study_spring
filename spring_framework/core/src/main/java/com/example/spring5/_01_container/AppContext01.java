package com.example.spring5._01_container;

import com.example.spring5.bean.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext01 {

	@Bean
	public Greeter greeter() {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s, 안녕하세요");
		return greeter;
	}
}
