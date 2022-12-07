package com.ljm.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser(String name){
        return "name: " + name;
    }

    @GetMapping("/error")
    public String getError(){
        int i = 1/0;
        return "success!";
    }
}
