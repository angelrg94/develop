package com.example.springrestfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	// En este punto podemos personalizar la documentacion
	public static final Contact DEFAULT_CONTACT = new Contact("Angel Gonzalez", "www.angelgonzalez.com", "angelgonzalez1594@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("My First Api Documentation", "The Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(Arrays.asList("aplication/json","aplication/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_PRODUCES);//Informacion general del api;
	}

}
