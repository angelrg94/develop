package com.example.springrestfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
		//Utilizando el locale como un parametro en el header
		@GetMapping(path="/hello-world-internationalized")
		public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
			return  messageSource.getMessage("good.morning.message", null, locale) ;
		}
		
		
		
		// Este metodo tiene internacionalizacion
		//Utilizando el locale como un parametro en el header
		//la diferencia en este caso es que no se configura el parametro para cada metodo 
		//el mismo es configudaro en el contexto y se recibe de igual manera en el header:Accept-Language
		@GetMapping(path="/hello-world-internationalized-context")
		public String helloWorldInternationalizedContext() {
			return  messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale()) ;
		}
		
}
