package com.learn.withravi.orderservice.publisher;

import com.learn.withravi.orderservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbitmq.exchange.order.name}")
    private String exchange;

    @Value("${rabbitmq.routing.order.key}")
    private String routingKey;

    @Value("${rabbitmq.binding.routing.email.key}")
    private String emailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendingOrderMessage(OrderEvent orderEvent) {
        logger.info(String.format("Sending order event message: %s", orderEvent.toString()));

        // Send order event to stock service
        rabbitTemplate.convertAndSend(exchange, routingKey, orderEvent);

        // Send order event to email service
        String emailMessage = String.format("Order with ID %s has been created.", orderEvent.toString());
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, orderEvent);
    }
}
