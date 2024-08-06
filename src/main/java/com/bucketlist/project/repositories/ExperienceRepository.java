package com.bucketlist.project.repositories;

import com.bucketlist.project.model.Category;
import com.bucketlist.project.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> findByCategory(Category category);
}
