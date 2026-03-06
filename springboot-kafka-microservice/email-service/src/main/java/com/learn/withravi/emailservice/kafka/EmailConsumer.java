package com.learn.withravi.emailservice.kafka;

import com.learn.withravi.basedomains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailConsumer.class);

    @KafkaListener(
            topics = {"${spring.kafka.topic.name}"},
            groupId = "${spring.kafka.consumer.group-id}")
    public  void consumeEmail(OrderEvent orderEvent){
        LOGGER.info("Consumed order event for email service: {}", orderEvent.toString());

        //send email to the user
    }
}
