package com.emblassignment.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.emblassignment.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableSwagger2
public class EMBLAssignment {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.emblassignment.springboot.controller"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }


	public static void main(String[] args) {
		SpringApplication.run(EMBLAssignment.class, args);
	}
}
