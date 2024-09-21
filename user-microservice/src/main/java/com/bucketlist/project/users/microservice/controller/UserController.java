package com.bucketlist.project.users.microservice.controller;

import com.bucketlist.project.users.microservice.payload.ExperienceMessageDTO;
import com.bucketlist.project.users.microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/experiences")
    public String addExperienceToUser(@PathVariable Long userId, @RequestBody ExperienceMessageDTO experienceMessageDTO) {
        // Extract the message from the DTO
        String experienceMessage = experienceMessageDTO.getExperienceMessage();

        // Delegate to the service layer
        userService.addExperienceToUser(userId, experienceMessage);
        return "Experience added to user and message sent to RabbitMQ";
    }
}
