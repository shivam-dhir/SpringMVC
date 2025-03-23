package com.shivam.SpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		System.out.println("app started");
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
