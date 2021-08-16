package com.mayur.jwtrestpractice1.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.mayur.jwtrestpractice1.Entities")
@EnableJpaRepositories(basePackages = "com.mayur.jwtrestpractice1.Repositories")
@ComponentScan(basePackages = {"com.mayur.jwtrestpractice1.Services", "com.mayur.jwtrestpractice1.Configurations", "com.mayur.jwtrestpractice1.Controllers", "com.mayur.jwtrestpractice1.Exceptions", "com.mayur.jwtrestpractice1.Repositories"})
public class JwtRestPractice1Application {

	public static void main(String[] args) {
		SpringApplication.run(JwtRestPractice1Application.class, args);
	}

}
