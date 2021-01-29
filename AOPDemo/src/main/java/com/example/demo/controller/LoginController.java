package com.example.demo.controller;

import com.example.demo.annotation.LogAnnotation;
import com.example.demo.annotation.RoleAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author kuanglifang
 * @date 2020/12/16 11:01
 */
@RestController
public class LoginController {
    @GetMapping("/hello")
    @LogAnnotation
    @RoleAnnotation
    public String auth() {
        System.out.println("========登录");
        return "hello";
    }
}
