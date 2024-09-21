package com.bucketlist.project.experiences.microservice.service;

import com.bucketlist.project.experiences.microservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveExperienceMessage(String message) {
        System.out.println("Received message: " + message);
        // Add logic to handle the message, e.g., adding/removing experiences
    }
}
