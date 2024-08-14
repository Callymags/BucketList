package com.bucketlist.project.controller;

import com.bucketlist.project.model.Experience;
import com.bucketlist.project.payload.ExperienceDTO;
import com.bucketlist.project.payload.ExperienceResponse;
import com.bucketlist.project.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @PostMapping("/categories/{categoryId}/experience/user/{userId}")
    public ResponseEntity<ExperienceDTO> addExperience (@Valid @RequestBody ExperienceDTO experienceDTO,
                                                        @PathVariable Long categoryId,
                                                        @PathVariable Long userId){
        ExperienceDTO savedExperienceDTO = experienceService.addExperience(categoryId, experienceDTO, userId);
        return new ResponseEntity<> (savedExperienceDTO, HttpStatus.CREATED);
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

    @GetMapping("/public/experiences/keyword/{keyword}")
    public ResponseEntity<ExperienceResponse> getExperienceByKeyword(@PathVariable String keyword){
        ExperienceResponse experienceResponse = experienceService.searchExperienceByKeyword(keyword);
        return new ResponseEntity<>(experienceResponse, HttpStatus.OK);
    }

    @PutMapping ("/experience/{experienceId}/user/{userId}")
    public ResponseEntity<ExperienceDTO> updateExperience(@Valid @RequestBody ExperienceDTO experienceDTO,
                                                          @PathVariable Long experienceId,
                                                          @PathVariable Long userId
    ){
        ExperienceDTO updatedExperienceDTO = experienceService.updateExperience(experienceId, experienceDTO, userId);
        return new ResponseEntity<>(updatedExperienceDTO, HttpStatus.OK);
    }

    @DeleteMapping("/experience/{experienceId}/user/{userId}")
    public ResponseEntity<ExperienceDTO> deleteExperience(@PathVariable Long experienceId,
                                                          @PathVariable Long userId){
        ExperienceDTO deletedExperience = experienceService.deleteExperience(experienceId, userId);
        return new ResponseEntity<>(deletedExperience, HttpStatus.OK);
    }

    @PutMapping("/experience/{experienceId}/image")
    public ResponseEntity<ExperienceDTO> updateExperienceImage(@PathVariable Long experienceId,
                                                               @RequestParam("image") MultipartFile image) throws IOException {
        ExperienceDTO updatedExperience = experienceService.updateExperienceImage(experienceId, image);
        return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
    }
}
