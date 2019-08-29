package com.appInNowBeta.app.ws.security;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.appInNowBeta.app.ws.SpringApplicationContext;
import com.appInNowBeta.app.ws.service.UserService;
import com.appInNowBeta.app.ws.shared.dto.UserDto;

import com.appInNowBeta.app.ws.ui.model.response.UserInfo;

import com.google.gson.Gson;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


//for final security attempt

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;







public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private final AuthenticationManager authenticationManager;
    
    private String contentType;
 
    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
 
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        contentType = req.getHeader("Accept");
      
		

    //       UserLoginRequestModel creds = new ObjectMapper()
      ///             .readValue(req.getInputStream(), UserLoginRequestModel.class);
    
		return authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(
		   
		        		req.getParameter("email"),
		        		req.getParameter("password"),
		                new ArrayList<>())
		);
    }
    
   
    @Override
    protected void successfulAuthentication(HttpServletRequest req, 
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws  IOException, ServletException {
        
     
    	
    	String userName = ((User) auth.getPrincipal()).getUsername();  
        
        String token = Jwts.builder()
                .setSubject(userName)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
                .compact();
        UserService userService= (UserService)SpringApplicationContext.getBean("userServiceImpl");
        UserDto userDto = userService.getUserByEmail(userName);
        
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        res.addHeader("userID", userDto.getUserId());
        
        
        //final attempt to add security
        
        UserInfo returnValue = new UserInfo();
		
		
		
		BeanUtils.copyProperties(userDto,returnValue);
        
        String       postUrl       = "http://localhost:8080/welcome/profile";// put in your url
        Gson         gson          = new Gson();
        HttpClient   httpClient    = HttpClientBuilder.create().build();
        HttpPost     post          = new HttpPost(postUrl);
        StringEntity postingString = new StringEntity(gson.toJson(returnValue));//gson.tojson() converts your returnValue to json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        post.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        post.setHeader("userID", userDto.getUserId());
        HttpResponse  response = httpClient.execute(post);
        
//        UserInfo returnValue = new UserInfo();
//        BeanUtils.copyProperties(userDto,returnValue);
//        String jsonString = new Gson().toJson(returnValue);
//        PrintWriter out = res.getWriter();
//        res.setContentType("application/json");
//        res.setCharacterEncoding("UTF-8");
//        res.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        //res.setHeader("Location", "http://localhost:8080/welcome/login/"+ userDto.getUserId() );
        
        
        
        res.sendRedirect("http://localhost:8080/welcome/profile/" + userDto.getUserId() );
//        res.sendRedirect("http://localhost:8080/welcome/login/"+ userDto.getUserId());
//        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
//        res.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
       
        
        
      

    }
    
   



   


}


    

