package com.bucketlist.project.controller;

import com.bucketlist.project.model.Experience;
import com.bucketlist.project.payload.ExperienceDTO;
import com.bucketlist.project.payload.ExperienceResponse;
import com.bucketlist.project.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @PostMapping("/categories/{categoryId}/experience")
    public ResponseEntity<ExperienceDTO> addExperience (@RequestBody Experience experience,
                                                        @PathVariable Long categoryId){
        ExperienceDTO experienceDTO = experienceService.addExperience(categoryId, experience);
        return new ResponseEntity<> (experienceDTO, HttpStatus.CREATED);
    }

    @GetMapping("/public/experiences")
    public ResponseEntity<ExperienceResponse> getAllExperiences() {
        ExperienceResponse experienceResponse = experienceService.getAllExperiences();
        return new ResponseEntity<>(experienceResponse, HttpStatus.OK);
    }

    @GetMapping("/public/categories/{categoryId}/experiences")
    public ResponseEntity<ExperienceResponse> getExperiencesByCategory(@PathVariable Long categoryId) {
        ExperienceResponse experienceResponse = experienceService.searchByCategory(categoryId);
        return new ResponseEntity<>(experienceResponse, HttpStatus.OK);
    }
}
