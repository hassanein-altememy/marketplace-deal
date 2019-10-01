package com.marketplace.deal.deal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @GetMapping("/test")
    public String getAllEmployees() {
        return "hello test";
    }
}
