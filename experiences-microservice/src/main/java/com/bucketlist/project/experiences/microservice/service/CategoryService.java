package com.bucketlist.project.experiences.microservice.service;

import com.bucketlist.project.experiences.microservice.payload.CategoryDTO;
import com.bucketlist.project.experiences.microservice.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
