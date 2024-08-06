package com.bucketlist.project.service;

import com.bucketlist.project.exceptions.ResourceNotFoundException;
import com.bucketlist.project.model.Category;
import com.bucketlist.project.model.Experience;
import com.bucketlist.project.payload.ExperienceDTO;
import com.bucketlist.project.payload.ExperienceResponse;
import com.bucketlist.project.repositories.CategoryRepository;
import com.bucketlist.project.repositories.ExperienceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ExperienceDTO addExperience(Long categoryId, Experience experience) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        experience.setCategory(category);
        Experience savedExperience = experienceRepository.save(experience);
        return modelMapper.map(savedExperience, ExperienceDTO.class);
    }

    @Override
    public ExperienceResponse getAllExperiences() {
        List<Experience> experiences = experienceRepository.findAll();
        List<ExperienceDTO> experienceDTOS = experiences.stream()
                .map(experience -> modelMapper.map(experience, ExperienceDTO.class))
                .collect(Collectors.toList());

        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setContent(experienceDTOS);
        return experienceResponse;
    }

    @Override
    public ExperienceResponse searchByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        List<Experience> experiences = experienceRepository.findByCategory(category);

        List<ExperienceDTO> experienceDTOS = experiences.stream()
                .map(experience -> modelMapper.map(experience, ExperienceDTO.class))
                .collect(Collectors.toList());

        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setContent(experienceDTOS);
        return experienceResponse;
    }
}
