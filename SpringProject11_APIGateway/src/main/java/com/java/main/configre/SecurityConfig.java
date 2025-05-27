package com.java.main.configre;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity()
public class SecurityConfig{
	
	@Bean()
	SecurityWebFilterChain securityWebChain(ServerHttpSecurity httpsecurity){
		httpsecurity
        			.authorizeExchange()
					.anyExchange()
					.authenticated()
					.and()
					.oauth2Client()
					.and()
					.oauth2ResourceServer()
					.jwt();
		return httpsecurity.build();
	}
	
	
	

}
