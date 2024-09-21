package com.bucketlist.project.experiences.microservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "experienceQueue";
    public static final String EXCHANGE_NAME = "experienceExchange";

    @Bean
    public Queue experienceQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public DirectExchange experienceExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).withQueueName();
    }
}