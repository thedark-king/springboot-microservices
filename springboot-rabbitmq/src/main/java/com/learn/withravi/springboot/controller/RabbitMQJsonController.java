package com.learn.withravi.springboot.controller;

import com.learn.withravi.springboot.dto.UserDto;
import com.learn.withravi.springboot.publisher.RabbitMQJsonProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    public RabbitMQJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }
//localhost:8080/api/v1/publish/json
    @PostMapping("/publish/json")
    public ResponseEntity<UserDto> sendJsonMessage(@RequestBody UserDto user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
