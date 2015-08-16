package com.mycompany.sp4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mycompany.sp4.core.HelloRepository;
import com.mycompany.sp4.core.HelloService;
import com.mycompany.sp4.core.HelloServiceImpl;

@Configuration
public class HelloConfig {

	@Bean
	public HelloService helloService(HelloRepository repository) {
		return new HelloServiceImpl(repository);
	}
}
