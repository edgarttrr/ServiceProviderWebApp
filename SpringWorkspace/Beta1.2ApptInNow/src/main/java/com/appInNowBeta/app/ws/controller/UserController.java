package com.appInNowBeta.app.ws.controller;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;





@Controller
public class UserController {

    @GetMapping("/greeting")
    public String greetingForm() {
        
        return "greeting";
    }
    
    @GetMapping("/welcome")
    public String workingWelcome() {
        
        return "welcome";
    }

    @PostMapping("/greeting")
    public String greetingSubmit() {
        return "result";
    }
    
    

}
