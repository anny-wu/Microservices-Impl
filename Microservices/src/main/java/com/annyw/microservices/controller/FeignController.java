package com.annyw.microservices.controller;
import com.annyw.microservices.feign.courseService;
import com.annyw.microservices.feign.hobbyService;
import com.annyw.microservices.feign.infoService;
import com.annyw.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class FeignController {
    
    @Autowired
    infoService info;
    @Autowired
    hobbyService hobby;
    @Autowired
    courseService course;
    
    
    @RequestMapping("/info")
    public List<String> getInfo(@RequestParam("id") String id){
        return info.getInfo(id);
    }
    
    @RequestMapping("/hobby")
    public List<String> getHobby(@RequestParam("id") String id){
        return hobby.getHobby(id);
    }
    @RequestMapping("/course")
    public List<String> getCourse(@RequestParam("id") String id) {
        return course.getCourse(id);
    }
}
