package com.project.shared;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:my-project-shared-application.properties")
public class MyProjectSharedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectSharedApplication.class, args);

	}

}
