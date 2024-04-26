package com.shoppers.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthCheck/")
public class HealthCheckController {

    @GetMapping("/probe")
    public String status() {
        return "OK";
    }
}
