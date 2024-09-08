package com.bucketlist.project.experiences.microservice.repositories;

import com.bucketlist.project.experiences.microservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}
