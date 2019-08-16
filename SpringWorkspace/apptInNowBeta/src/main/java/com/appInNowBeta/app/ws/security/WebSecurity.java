package com.appInNowBeta.app.ws.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.appInNowBeta.app.ws.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    
    
   
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
        .csrf().disable().authorizeRequests()
        // ignore all URLs that start with /resources/ or /static/
        .antMatchers(HttpMethod.GET,"/css/**", "/static/**","/js/**")
        .permitAll()
        .antMatchers(HttpMethod.POST, "/welcome/users")
        .permitAll()
        .antMatchers(HttpMethod.POST, "/welcome/calendar")
        .permitAll()
        .antMatchers(HttpMethod.POST, "/welcome/signIn")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/welcome/login")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/welcome/calendar")
        .permitAll()
        .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
        .permitAll()
        .antMatchers(HttpMethod.GET, "/welcome/signIn")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/welcome/service")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/welcome/users")
        .permitAll()
        .antMatchers(HttpMethod.GET, "/welcome")
        .permitAll()
        .anyRequest().authenticated().and()
        .addFilter(getAuthenticationFilter())
        .addFilter(new AuthorizationFilter(authenticationManager()))
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 

        
        
        
    }
    
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
    
    
    protected AuthenticationFilter getAuthenticationFilter() throws Exception {
//    	if (HttpMethod.POST != null) {
//    		  
    	final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
	    filter.setFilterProcessesUrl("/welcome/login");
	    return filter;
//    	}else {
//    		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
//    	    filter.setFilterProcessesUrl("/welcome/nothing");
//    	    return filter;
//    	}
    	
    	
	}
    
    
    
  
    
 
    
}
