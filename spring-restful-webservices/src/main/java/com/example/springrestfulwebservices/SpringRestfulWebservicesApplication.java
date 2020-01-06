package com.example.springrestfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringRestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulWebservicesApplication.class, args);
	}

	@Bean 
	//Bean encargado de manejar el locale por default
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	//Bean encargado de cargar los archivos con mensajes
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageResource = new ResourceBundleMessageSource();
		messageResource.setBasename("messages");
		return messageResource;
	}
}
