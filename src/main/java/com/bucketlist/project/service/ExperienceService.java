package com.bucketlist.project.service;

import com.bucketlist.project.model.Experience;
import com.bucketlist.project.payload.ExperienceDTO;
import com.bucketlist.project.payload.ExperienceResponse;

public interface ExperienceService {
    ExperienceDTO addExperience(Long categoryId, Experience experience);

    ExperienceResponse getAllExperiences();

    ExperienceResponse searchByCategory(Long categoryId);
}
