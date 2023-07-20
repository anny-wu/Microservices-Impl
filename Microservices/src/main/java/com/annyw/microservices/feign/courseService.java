package com.annyw.microservices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("COURSE-SERVICE")
public interface courseService {
    @RequestMapping("/course")
    List<String> getCourse(@RequestParam("id") String id);
}
