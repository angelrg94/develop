package com.example.springrestfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrestfulwebservices.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {
	
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
}
