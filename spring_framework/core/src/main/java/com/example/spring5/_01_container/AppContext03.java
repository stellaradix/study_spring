package com.example.spring5._01_container;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppContext01.class, AppContext02.class})
public class AppContext03 {

}
