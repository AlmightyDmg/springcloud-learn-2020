package cn.com.dmg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

    @RequestMapping("hello")
    String hello() {
        return "Hello World!Hello Spring Cloud!";
    }

}