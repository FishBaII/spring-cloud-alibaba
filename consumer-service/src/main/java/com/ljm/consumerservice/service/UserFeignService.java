package com.ljm.consumerservice.service;

import com.ljm.consumerservice.service.fallback.UserFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service", contextId = "userService",fallbackFactory = UserFeignFallbackFactory.class)
public interface UserFeignService {

    //相当于访问 user-service/user?name={name}
    @GetMapping("/user")
    String getUserByNameInFeign(@RequestParam(value = "name") String name);

    @GetMapping("/user/error")
    String getErrorInFeign();
}
