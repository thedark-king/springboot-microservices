package com.learn.withravi.orderservice.controller;

import com.learn.withravi.orderservice.dto.Order;
import com.learn.withravi.orderservice.dto.OrderEvent;
import com.learn.withravi.orderservice.publisher.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private static OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {

        this.orderProducer = orderProducer;
    }
//localhost:8080/api/v1/orders

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        // Logic to place an order
        // ...
        order.setOrder_id(UUID.randomUUID().toString());

        // Create an OrderEvent object with order details
        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Order is in pending state");
        event.setOrder(order);

        // Send the order event message to RabbitMQ
        // orderProducer.sendingOrderMessage(orderEvent);
        orderProducer.sendingOrderMessage(event);

        return "Order placed successfully!";
    }


}
