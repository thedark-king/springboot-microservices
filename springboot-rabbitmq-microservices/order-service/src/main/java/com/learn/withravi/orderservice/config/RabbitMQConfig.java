package com.learn.withravi.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //Spring bean for queue - order queue
    //Spring bean for exchange - topic exchange
    //binding between queue and exchange using routing key
    //message converter for json messages for order
    //configure rabbit template to use the json message converter
    @Value("${rabbitmq.queue.order.name}")
    private String orderQueue;

    @Value("${rabbitmq.exchange.order.name}")
    private String orderExchange;

    @Value("${rabbitmq.routing.order.key}")
    private String order_routing_key;

    @Value("${rabbitmq.queue.email.name}")
    private String emailQueue;


    @Value("${rabbitmq.binding.routing.email.key}")
    private String email_routing_key;

//Spring bean for queue - orderqueue
    @Bean
    public Queue queue() {
        return QueueBuilder
                .durable(orderQueue)
                .build();
    }
//Spring bean for queue - email queue
@Bean
public Queue emailQueue(){
    return QueueBuilder
            .durable(emailQueue)
            .build();
}

//Spring bean for exchange - topic exchange

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(orderExchange);
    }
//binding between queue and exchange using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(order_routing_key);
    }
    //binding between email queue and exchange using routing key

    @Bean
    public Binding emailbinding(){
        return BindingBuilder
                .bind(emailQueue())
                .to(exchange())
                .with(email_routing_key);
    }

    //Message converter for json messages for order
    @Bean
    public MessageConverter converter(){
        return new JacksonJsonMessageConverter();
    }

//    Configure rabbit template to use the json message converter
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }




}
