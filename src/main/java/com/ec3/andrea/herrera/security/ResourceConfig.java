package com.ec3.andrea.herrera.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		super.configure(resources);
	}

	
	// Metodo para dar permiso a los recursos
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.anonymous().disable();
		
		// Autorizar peticiones a los recursos, si el token es valido accede a todo de /especialidades/v1/**
		// Si falla le enviamos un acceso denegado de tipo OAuth accessDeniedHandler...
		http.authorizeRequests()
			.antMatchers("/especialidades/v1/**").permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}
