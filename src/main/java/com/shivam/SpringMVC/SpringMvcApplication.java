package com.shivam.SpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @ComponentScan -> scan specified packages for annotations (Component, Repository) and then create beans
// @EntityScan -> packages with Entity classes have to be mentioned separately
// @EnableJpaRepository -> Same goes as above for JpaRepository
@SpringBootApplication
@ComponentScan(basePackages={"com.shivam"})
@EntityScan(basePackages="com.shivam.model")
@EnableJpaRepositories(basePackages = "com.shivam.dao")
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
