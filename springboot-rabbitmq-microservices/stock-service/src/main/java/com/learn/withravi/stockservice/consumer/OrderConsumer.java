package com.learn.withravi.stockservice.consumer;

import com.learn.withravi.stockservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);


    @RabbitListener(queues = "${rabbitmq.queue.order.name}")
    public void consumeOrderEvent(OrderEvent orderEvent){
        logger.info(String.format("Received order event message: %s", orderEvent.toString()));
        // Here you can add logic to process the order event, such as updating stock levels, etc.
        // After that we can perform database operations to update the stock levels based on the order event.

    }
}
