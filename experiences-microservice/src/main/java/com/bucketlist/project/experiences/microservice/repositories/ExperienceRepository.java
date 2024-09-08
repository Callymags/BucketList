package com.bucketlist.project.experiences.microservice.repositories;

import com.bucketlist.project.experiences.microservice.model.Category;
import com.bucketlist.project.experiences.microservice.model.Experience;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    Page<Experience> findByCategory(Category category, Pageable pageDetails);

    Page<Experience> findByExperienceNameLikeIgnoreCase(String s, Pageable keyword);
}
