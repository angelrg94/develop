package com.example.springrestfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestfulwebservices.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public  HelloWorldBean helloWorldBean() {
		
		return new  HelloWorldBean("Hello World");
	}

	// GET with path variable
		@GetMapping(path="/hello-world-bean/path-variable/{name}")
		public  HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
			
			return new  HelloWorldBean(String.format("Hello World, %s",name));
		}
		
		// Este metodo tiene internacionalizacion
		@GetMapping(path="/hello-world-internationalized")
		public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
			return  messageSource.getMessage("good.morning.message", null, locale) ;
		}
}
