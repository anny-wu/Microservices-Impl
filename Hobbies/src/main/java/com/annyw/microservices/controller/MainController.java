package com.annyw.microservices.controller;

import com.annyw.microservices.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MainController {
    @Autowired
    RelationshipService relationshipService;
    
    @GetMapping("/hobby")
    public List<String> getDisplay(@RequestParam("id") String id){
        return relationshipService.getHobbiesById(Integer.parseInt(id));
    }
    
}
