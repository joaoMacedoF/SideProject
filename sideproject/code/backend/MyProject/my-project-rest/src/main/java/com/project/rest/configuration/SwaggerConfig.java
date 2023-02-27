package com.project.rest.configuration;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.project.rest.translation.SwaggerPageable;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final String BASE_PACKAGE = "com.project.api";
	
	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("MyProject - Api Documentation")
            .description("Project to Practice REST-API")
            .version("1.0.0")
            .build();
    }
	
	@Bean
	public Docket api(ServletContext servletContext) {
		return new Docket(DocumentationType.OAS_30).select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.directModelSubstitute(Pageable.class, SwaggerPageable.class)
				.apiInfo(apiInfo());
	}

}
