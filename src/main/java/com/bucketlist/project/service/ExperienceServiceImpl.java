package com.bucketlist.project.service;

import com.bucketlist.project.exceptions.APIException;
import com.bucketlist.project.exceptions.PermissionDeniedException;
import com.bucketlist.project.exceptions.ResourceNotFoundException;
import com.bucketlist.project.model.Category;
import com.bucketlist.project.model.Experience;
import com.bucketlist.project.payload.ExperienceDTO;
import com.bucketlist.project.payload.ExperienceResponse;
import com.bucketlist.project.repositories.CategoryRepository;
import com.bucketlist.project.repositories.ExperienceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Autowired
    private FileService fileService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public ExperienceDTO addExperience(Long categoryId, ExperienceDTO experienceDTO, Long userId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        boolean isExpNotPresent = true;

        List<Experience> experiences = category.getExperiences();

        for (Experience value : experiences) {
            if (value.getExperienceName().equals(experienceDTO.getExperienceName())) {
                isExpNotPresent = false;
                break;
            }
        }

        if (isExpNotPresent){
            Experience experience = modelMapper.map(experienceDTO, Experience.class);
            experience.setImgAddress("default.jpg");
            experience.setCategory(category);
            experience.setAddedBy(userId);
            experience.setLastModifiedBy(userId);

            Experience savedExperience = experienceRepository.save(experience);
            return modelMapper.map(savedExperience, ExperienceDTO.class);
        } else {
            throw new APIException("Experience already exists");
        }

    }

    @Override
    public ExperienceResponse getAllExperiences() {
        List<Experience> experiences = experienceRepository.findAll();
        List<ExperienceDTO> experienceDTOS = experiences.stream()
                .map(experience -> modelMapper.map(experience, ExperienceDTO.class))
                .collect(Collectors.toList());

        if (experiences.isEmpty()){
            throw new APIException("No experiences exist");
        }

        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setContent(experienceDTOS);
        return experienceResponse;
    }

    @Override
    public ExperienceResponse searchByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        List<Experience> experiences = experienceRepository.findByCategory(category);

        if (experiences.isEmpty()) {
            throw new APIException("No experiences found for the given category");
        }

        List<ExperienceDTO> experienceDTOS = experiences.stream()
                .map(experience -> modelMapper.map(experience, ExperienceDTO.class))
                .collect(Collectors.toList());

        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setContent(experienceDTOS);
        return experienceResponse;
    }

    @Override
    public ExperienceResponse searchExperienceByKeyword(String keyword) {
        List<Experience> experiences = experienceRepository.findByExperienceNameLikeIgnoreCase('%' + keyword + '%');

        List<ExperienceDTO> experienceDTOS = experiences.stream()
                .map(experience -> modelMapper.map(experience, ExperienceDTO.class))
                .collect(Collectors.toList());

        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setContent(experienceDTOS);
        return experienceResponse;
    }

    @Override
    public ExperienceDTO updateExperience(Long experienceId, ExperienceDTO experienceDTO, Long userId) {
        Experience experienceFromDB = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "experienceId", experienceId));

        Experience experience = modelMapper.map(experienceDTO, Experience.class);

        // If admin or user that added experience
        if (userId.equals(1001L) || experienceFromDB.getAddedBy().equals(userId)) {
        experienceFromDB.setExperienceName(experience.getExperienceName());
        experienceFromDB.setDescription(experience.getDescription());
        experienceFromDB.setImgAddress(experience.getImgAddress());
        experienceFromDB.setLastModifiedBy(userId);

        Experience savedExperience = experienceRepository.save(experienceFromDB);

        return modelMapper.map(savedExperience, ExperienceDTO.class);
        } else {
            throw new PermissionDeniedException("UserId", userId, "experience", "update");
        }

    }

    @Override
    public ExperienceDTO deleteExperience(Long experienceId, Long userId) {
        Experience experienceFromDB = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "experienceId", experienceId));

        // If admin or user that added experience
        if (userId.equals(1001L) || experienceFromDB.getAddedBy().equals(userId)) {
        experienceRepository.delete(experienceFromDB);
        return modelMapper.map(experienceFromDB, ExperienceDTO.class);
        } else {
            throw new PermissionDeniedException("UserId", userId, "experience", "delete");
        }
    }

    @Override
    public ExperienceDTO updateExperienceImage(Long experienceId, MultipartFile image) throws IOException {
        Experience experienceFromDB = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "experienceId", experienceId));
        String fileName = fileService.uploadImage(uploadDir, image);
        experienceFromDB.setImgAddress(fileName);
        Experience updatedExperience = experienceRepository.save(experienceFromDB);
        return modelMapper.map(updatedExperience, ExperienceDTO.class);
    }
}
