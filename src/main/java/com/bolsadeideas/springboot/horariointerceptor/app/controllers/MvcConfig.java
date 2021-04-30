package com.bolsadeideas.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired
	@Qualifier("horario")
	private HandlerInterceptor horario;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//PARA QUE SE APLIQUE TODO A CERRADO SINO HACE INFINITE LOOP
		registry.addInterceptor(horario).excludePathPatterns("/cerrado");
	}

}
