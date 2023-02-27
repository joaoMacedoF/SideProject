package com.project.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.project.rest.configuration.CustomizedApiListingReferenceScanner;

import springfox.documentation.spring.web.scanners.ApiListingReferenceScanner;

@SpringBootApplication
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:my-project-shared-application.properties")})
@ComponentScan(basePackages = "com.project")
public class MyProjectRestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyProjectRestApplication.class, args);

	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

//	@Bean
//	public LocalValidatorFactoryBean getValidator() {
//		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//		bean.setValidationMessageSource(messageSource());
//		return bean;
//	}
	
//	@Bean
//	@Primary
//	public ApiListingReferenceScanner apiListingReferenceScanner()
//	{
//		return new CustomizedApiListingReferenceScanner();
//	}


}
