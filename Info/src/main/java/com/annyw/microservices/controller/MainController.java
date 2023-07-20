package com.annyw.microservices.controller;

import com.annyw.microservices.bean.User;
import com.annyw.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MainController {
    @Autowired
    UserService userService;
    @GetMapping("/info")
    public List<String> getDisplay(@RequestParam("id") String id){
        User user = userService.getUserById(Integer.parseInt(id));
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(user.getId()));
        result.add(user.getUsername());
        result.add(String.valueOf(user.getAge()));
        return result;
    }
    
}
