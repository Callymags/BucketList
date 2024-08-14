package com.bucketlist.project.service;

import com.bucketlist.project.payload.ExperienceDTO;
import com.bucketlist.project.payload.ExperienceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExperienceService {
    ExperienceDTO addExperience(Long categoryId, ExperienceDTO experience, Long userId);

    ExperienceResponse getAllExperiences();

    ExperienceResponse searchByCategory(Long categoryId);

    ExperienceResponse searchExperienceByKeyword(String keyword);

    ExperienceDTO updateExperience(Long experienceId, ExperienceDTO experience, Long userId);

    ExperienceDTO deleteExperience(Long experienceId, Long userId);

    ExperienceDTO updateExperienceImage(Long experienceId, MultipartFile image) throws IOException;
}
