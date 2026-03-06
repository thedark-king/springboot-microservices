package com.learn.withravi.orderservice.controller;

import com.learn.withravi.basedomains.dto.Order;
import com.learn.withravi.basedomains.dto.OrderEvent;
import com.learn.withravi.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;
//localhost:8080/api/v1/orders
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending");
        orderEvent.setMessage("Order status is pending");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return  "Order placed successfully with order id: " + order.getOrderId();

    }
}
