package com.annyw.microservices.controller;
import com.annyw.microservices.bean.User;
import com.annyw.microservices.service.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.*;

@Controller
public class MainController {
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplateBean(){
        return new RestTemplate();
    }
    
    @Autowired
    private RestTemplate rest;
    @Autowired
    UserService userService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(value="selected", required = false) String selected){
        model.addAttribute("users", userService.getAllUsers());
        if(selected == null){
            model.addAttribute("selected", 1);
        }
        else{
            model.addAttribute("selected", selected);
        }
        return "index";
    }
    
    @PostMapping("/")
    public String getDatabase(Model model,
        @RequestParam("id") int id, @RequestParam(value="INFO", required = false) String info,
                              @RequestParam(value="HOBBIES", required = false) String hobbies,
                              @RequestParam(value="COURSES", required = false) String courses)
        throws ClassNotFoundException, IOException {
        model.addAttribute("users", userService.getAllUsers());
        
        if (info != null) {
            //Pass column values
            model.addAttribute("dbInfo", "info");
            final String uri = "http://info-service?id=" + id;
            Object response = rest.getForObject(uri, ArrayList.class);
            model.addAttribute("info", response);
            
        }
        if (hobbies != null) {
            //Pass column values
            model.addAttribute("dbHobbies", "hobbies");
            final String uri = "http://hobby-service?id=" + id;
            Object response = rest.getForEntity(uri, List.class);
            model.addAttribute("hobbies", response);
        }
        
        if (courses != null) {
            //Pass column values
            model.addAttribute("dbCourses", "courses");
            final String uri = "http://course-service?id=" + id;
            Object response
                = rest.getForEntity(uri, List.class);
            model.addAttribute("courses", response);
        }
        
        model.addAttribute("selected", id);
        return "index";
    }
}
