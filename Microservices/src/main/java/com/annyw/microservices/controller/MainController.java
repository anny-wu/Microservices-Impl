package com.annyw.microservices.controller;

import com.annyw.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @Autowired
    FeignController controller;
    @Autowired
    UserService userService;
    @Autowired
    Environment environment;
    
    @GetMapping("/")
    public String index(Model model,  @RequestParam(value="selected", required = false) String selected){
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
        @RequestParam(value="INFO", required = false) String info, @RequestParam("ids") String id,
        @RequestParam(value="HOBBIES", required = false) String hobbies,
        @RequestParam(value="COURSES", required = false) String courses) {
        
        model.addAttribute("users", userService.getAllUsers());
        
        if (info != null) {
            //Pass column values
            model.addAttribute("dbInfo", "info");
            model.addAttribute("info",controller.getInfo(id));
        }
        if (hobbies != null) {
            //Pass column values
            model.addAttribute("dbHobbies", "hobbies");
            model.addAttribute("hobbies", controller.getHobby(id));
        }
        if (courses != null) {
            //Pass column values
            model.addAttribute("dbCourses", "courses");
            model.addAttribute("courses", controller.getCourse(id));
        }
        
        model.addAttribute("selected", Integer.parseInt(id));
        return "index";
    }
}
