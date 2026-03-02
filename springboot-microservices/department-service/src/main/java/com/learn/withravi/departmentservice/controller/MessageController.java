package com.learn.withravi.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/messages")
public class MessageController {
//localhost:8080/api/messages
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping()
    public String getMessage() {
        return message;
    }
}
