package com.drinkfish.community.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DrinkFish
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello SpringBoot";
    }
}
