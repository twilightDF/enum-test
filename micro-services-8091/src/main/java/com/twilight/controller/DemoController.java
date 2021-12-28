package com.twilight.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DemoController {
    @GetMapping()
    public String helloWorld(){
        System.out.println("in .....");
        return "i`m from 8091";
    }
}
