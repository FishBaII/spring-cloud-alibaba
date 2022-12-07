package com.ljm.consumerservice.controller;

import com.ljm.consumerservice.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserFeignService userFeignService;

    @GetMapping
    public String getUser(String name){
        return userFeignService.getUserByNameInFeign(name);
    }

    @GetMapping("/error")
    public String getError(){
        return userFeignService.getErrorInFeign();
    }
}
