package com.example.spring.controller;

import com.example.spring.model.Order;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuanglifang
 * @date 2021/3/5 11:26
 */
@RestController
public class OrderController {
    @PostMapping
    public String add(@Validated Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "has error";
        }
        return "success";
    }
}
