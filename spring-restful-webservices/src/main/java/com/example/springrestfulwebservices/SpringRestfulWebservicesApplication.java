package com.example.springrestfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringRestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulWebservicesApplication.class, args);
	}

	/*@Bean 
	//Bean encargado de manejar el locale por default
	//con este metodo definimos el locale de manera default.
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	*/
	
	//Con este metodo tambien definimos el  Locale pero a traves del Header :Accept-Language 
	//esto permite luego tomar el Local del contexto para así no tener que configurar el parametro en cada endpoint
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	
/*	@Bean
	//Bean encargado de cargar los archivos con mensajes esto es opcional ya que se puede cargar directamente en el
	//application.properties
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageResource = new ResourceBundleMessageSource();
		messageResource.setBasename("messages");
		return messageResource;
	}*/
}
   