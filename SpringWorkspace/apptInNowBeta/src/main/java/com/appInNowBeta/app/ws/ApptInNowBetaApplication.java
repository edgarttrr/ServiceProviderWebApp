package com.appInNowBeta.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.appInNowBeta.app.ws.security.AppProperties;

@EnableAutoConfiguration
@SpringBootApplication
public class ApptInNowBetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptInNowBetaApplication.class, args);
	}
	
	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	
	@Bean(name="AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}

}
