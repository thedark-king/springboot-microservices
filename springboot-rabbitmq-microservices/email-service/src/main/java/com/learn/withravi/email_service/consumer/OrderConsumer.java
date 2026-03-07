package com.learn.withravi.email_service.consumer;

import com.learn.withravi.email_service.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consumeOrderEvent(OrderEvent event){
        logger.info(String.format("Received order event message: %s", event.toString()));

        // Here you can add logic to process the order event, such as sending an email notification, etc.
        // After that we can perform database operations to update the stock levels based on the order event.
    }
}
