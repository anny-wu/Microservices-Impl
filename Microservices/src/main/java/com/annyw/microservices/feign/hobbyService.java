package com.annyw.microservices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("HOBBY-SERVICE")
public interface hobbyService {
    @RequestMapping("/hobby")
    List<String> getHobby(@RequestParam("id") String id);
}
