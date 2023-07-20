package com.annyw.microservices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("INFO-SERVICE")
public interface infoService {
    @RequestMapping("/info")
    List<String> getInfo(@RequestParam("id") String id);
}
