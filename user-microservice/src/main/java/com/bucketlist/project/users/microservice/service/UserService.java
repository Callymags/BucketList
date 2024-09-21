package com.bucketlist.project.users.microservice.service;

import com.bucketlist.project.users.microservice.model.User;
import com.bucketlist.project.users.microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RabbitMQSender rabbitMQSender;  // The RabbitMQ sender component

    // Assume you have a repository to manage User data
    @Autowired
    private UserRepository userRepository;

    public void addExperienceToUser(Long userId, String experienceMessage) {
        // Logic to add experience to the user's profile
        // Example: You would fetch the user by ID and update their list of experiences.

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        // Add logic to update the user's experience list (if stored locally)

        // Send a message to RabbitMQ
        rabbitMQSender.sendExperienceMessage(experienceMessage);
    }
}
