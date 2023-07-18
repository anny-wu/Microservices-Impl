package com.annyw.microservices.controller;

import com.annyw.microservices.bean.Hobbies;
import com.annyw.microservices.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MainController {
    @Autowired
    RelationshipService relationshipService;
    
    @GetMapping("/hobbies")
    public Object getDisplay(@RequestParam("id") String id){
        List<String> hobbies = relationshipService.getHobbiesById(Integer.parseInt(id));
        return hobbies;
    }
    
}
