package com.project.rest.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.rest.filter.ExportRequestFilter;



@Configuration
public class FilterConfiguration implements WebMvcConfigurer {
	
	private static final String URL_PATTERNS = "/api/*";
	
	@Bean
	public FilterRegistrationBean<ExportRequestFilter> requestFilter() {
		FilterRegistrationBean<ExportRequestFilter> registrationBean = new FilterRegistrationBean<ExportRequestFilter>();

		registrationBean.setFilter(new ExportRequestFilter());
		registrationBean.addUrlPatterns(URL_PATTERNS);

		return registrationBean;
	}
	
	@SuppressWarnings("deprecation")
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer
	    .favorPathExtension(true)
	    .favorParameter(false)
	    .ignoreAcceptHeader(true);
	}

}
